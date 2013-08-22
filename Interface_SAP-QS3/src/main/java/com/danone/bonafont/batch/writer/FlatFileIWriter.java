package com.danone.bonafont.batch.writer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.core.io.Resource;

import com.danone.bonafont.batch.dao.ArchivoDAO;
import com.danone.bonafont.batch.dao.Qs3OrdenDAO;
import com.danone.bonafont.batch.model.Qs3Orden;
import com.danone.bonafont.batch.reader.FlatFileReader;
import com.danone.bonafont.batch.util.Constants;

/**
 * @author Eduardo Rodriguez Class register out file and update status of order
 */
public class FlatFileIWriter extends FlatFileItemWriter<Qs3Orden> {

	private static final Logger LOG = Logger.getLogger(FlatFileReader.class);
	private boolean isError = false;
	private Long idArchivo;
	private Resource resource;

	@javax.annotation.Resource
	Qs3OrdenDAO qs3OrdenDAO;

	@javax.annotation.Resource
	ArchivoDAO archivoDAO;

	List<Qs3Orden> items;

	@Override
	public void setResource(Resource resource) {
		LOG.debug("File Name: " + resource.getFilename());
		this.resource = resource;
		super.setResource(resource);
	}

	@Override
	public void write(List<? extends Qs3Orden> items) throws Exception {
		this.items = new ArrayList<Qs3Orden>(items);
		try {
			super.write(items);
		} catch (Exception e) {
			this.isError = true;
			throw e;
		}
		this.idArchivo = archivoDAO.registerFile(this.resource.getFilename(),
				Constants.ARCHIVO_GENERADO, Constants.QS3_SAP_OR_CREATION);
	}

	@Override
	public void close() {
		super.close();
		updateState();
	}

	private void updateState() {
		if (!isError && items != null) {
			for (Qs3Orden qs3 : items) {
				qs3.setNu_id_estatus(Constants.REG_PROCESADO);
				qs3.setDa_proceso(new Date());
				qs3.setNu_id_archivo(idArchivo);
			}
			qs3OrdenDAO.update(items);
		}

	}
}
