package com.danone.bonafont.batch.writer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.core.io.Resource;

import com.danone.bonafont.batch.dao.ArchivoDAO;
import com.danone.bonafont.batch.dao.Qs3StoDAO;
import com.danone.bonafont.batch.model.Qs3STO;
import com.danone.bonafont.batch.util.Constants;

/**
 * @author Eduardo Rodriguez Class register out file and update status of order
 */
public class FlatFileIWriterQs3Sto extends FlatFileItemWriter<Qs3STO> {

	private static final Logger LOG = Logger.getLogger(FlatFileIWriterQs3Sto.class);
	private boolean isError = false;
	private Long idArchivo;
	private Resource resource;

	@javax.annotation.Resource
	Qs3StoDAO qs3StoDAO;

	@javax.annotation.Resource
	ArchivoDAO archivoDAO;

	List<Qs3STO> items;

	@Override
	public void setResource(Resource resource) {
		LOG.debug("File Name: " + resource.getFilename());
		this.resource = resource;
		super.setResource(resource);
	}

	@Override
	public void write(List<? extends Qs3STO> items) throws Exception {
		this.items = new ArrayList<Qs3STO>(items);
		try {
			super.write(items);
		} catch (Exception e) {
			this.isError = true;
			throw e;
		}
		this.idArchivo = archivoDAO.registerFile(this.resource.getFilename(),
				Constants.ARCHIVO_GENERADO, Constants.QS3_SAP_STO);
	}

	@Override
	public void close() {
		super.close();
		updateState();
	}

	private void updateState() {
		if (!isError && items != null) {
			for (Qs3STO qs3 : items) {
				qs3.setNu_id_estatus(Constants.REG_PROCESADO);
				qs3.setDa_proceso(new Date());
				qs3.setNu_id_archivo(idArchivo);
			}
			qs3StoDAO.update(items);
		}

	}
}
