package com.danone.bonafont.batch.reader;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.core.io.Resource;

import com.danone.bonafont.batch.dao.ArchivoDAO;
import com.danone.bonafont.batch.model.Archivo;
import com.danone.bonafont.batch.util.Constants;

/**
 * @author Eduardo Rodriguez 
 * Wrapper class by reader the inputs files
 */
public class FlatFileReader<T> extends FlatFileItemReader<T> {

	private static final Logger LOG = Logger.getLogger(FlatFileReader.class);
	protected Resource resource;
	protected boolean isError = false;
	protected Long idArchivo;

	@javax.annotation.Resource
	ArchivoDAO archivoDAO;

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
			if (file.renameTo(new File(newParent + file.getName()))) {
				LOG.info("OK Move File " + newParent + file.getName());
			} else {
				LOG.error("FAILED Move File ");
			}
		}
	}
	
	private void updateFile(){
		if(this.isError){
			Archivo archivo = archivoDAO.findByPK(Archivo.class, idArchivo);
			archivo.setNu_id_estatus(Constants.ARCHIVO_ERROR);
			archivoDAO.update(archivo);
		}
	}

	@Override
	public void update(ExecutionContext executionContext)
			throws ItemStreamException {
		if (executionContext.get("anErrorHappened") != null && !this.isError) {
			this.isError = executionContext.getInt("anErrorHappened") == 1;
		}
		super.update(executionContext);
	}
	
	@Override
	protected void doOpen() throws Exception {
		this.isError = false;
		super.doOpen();
	}

}
