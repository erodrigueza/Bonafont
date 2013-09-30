package com.danone.bonafont.batch.reader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.core.io.Resource;

import com.danone.bonafont.batch.dao.ArchivoDAO;
import com.danone.bonafont.batch.model.Archivo;
import com.danone.bonafont.batch.util.Constants;
import com.danone.bonafont.batch.util.Util;

/**
 * @author Eduardo Rodriguez 
 * Wrapper class by reader the inputs files
 */
public class FlatFileReader<T> extends FlatFileItemReader<T> {

	private static final Logger LOG = Logger.getLogger(FlatFileReader.class);
	protected Resource resource;
	protected boolean isError;
	protected boolean isDuplicate;
	protected String desError = "";
	protected Long idArchivo;

	@javax.annotation.Resource
	ArchivoDAO archivoDAO;

	public void setResource(Resource resource, Integer interfaz) {
		LOG.info("File Name: " + resource.getFilename());
		this.resource = resource;
		isDuplicate = false;
		regFile(resource, interfaz);
		super.setResource(resource);
	}

	private void regFile(Resource resource, Integer interfaz) {
		List<Archivo> archivos = archivoDAO.findByName(resource.getFilename());
		if(archivos.size() > 0){
			isDuplicate = true;
		}
		try{
			idArchivo = archivoDAO.registerFile(resource.getFilename(),
								Constants.ARCHIVO_PROCESANDO, interfaz);
			isError = false;
		}catch (Exception e){
			LOG.error("Error al registrar el archivo, excepcion: "+e.getMessage());
			isError = true;
		}
	}
	
	@Override
	protected void doClose() throws Exception {
		super.doClose();
		moveFile();
		updateFile();
	}

	private void moveFile() throws IOException {
		if (resource != null && resource.getFile().exists()) {
			File file = resource.getFile();
			String parent = file.getParent();
			String newParent = parent.substring(0, parent.length() - 3)
					+ (this.isError ? "error\\" : "processed\\");
			
			File newFile = new File(newParent + file.getName());

			if(newFile.exists()){
				LOG.info("El archivo ya existe en la carpeta destino..!!");
				newFile = new File(newParent + Util.getDateSeg() +file.getName());
			}
			
			if (file.renameTo(newFile)) {
				LOG.info("OK Move File " + newFile.getPath());
			} else {
				LOG.error("FAILED Move File ");
				desError = Constants.ERR_FILE_MOVE;
			}
		}
	}
	
	private void updateFile(){
		Archivo archivo = archivoDAO.findByPK(Archivo.class, idArchivo);
		if(this.isError){
			archivo.setNu_id_estatus(Constants.ARCHIVO_ERROR);
			archivo.setCh_descripcion(desError);
		}else if(isDuplicate){
			archivo.setNu_id_estatus(Constants.ARCHIVO_DUPLICADO);
			archivo.setCh_descripcion("Archivo Duplicado");
		}else{
			archivo.setNu_id_estatus(Constants.ARCHIVO_LEIDO);
		}
		archivoDAO.update(archivo);
	}

	@Override
	public void update(ExecutionContext executionContext)
			throws ItemStreamException {
		if (executionContext.get("anErrorHappened") != null && !this.isError) {
			this.isError = executionContext.getInt("anErrorHappened") == 1;
			desError = Constants.ERR_FILE_DATA;
		}
		super.update(executionContext);
	}
	
}
