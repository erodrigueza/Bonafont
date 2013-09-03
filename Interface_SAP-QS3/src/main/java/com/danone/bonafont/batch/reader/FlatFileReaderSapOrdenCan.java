package com.danone.bonafont.batch.reader;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;

import com.danone.bonafont.batch.model.SapOrdenCan;
import com.danone.bonafont.batch.util.Constants;

/**
 * @author Eduardo Rodriguez 
 * Wrapper class by reader the inputs files
 */
public class FlatFileReaderSapOrdenCan extends FlatFileReader<SapOrdenCan> {

	private static final Logger LOG = Logger.getLogger(FlatFileReaderSapOrdenCan.class);

	@Override
	public void setResource(Resource resource) {
		LOG.debug("File Name: " + resource.getFilename());
		super.resource = resource;
		super.idArchivo = super.archivoDAO.registerFile(resource.getFilename(),
				Constants.ARCHIVO_LEIDO, Constants.SAP_QS3_OR_CANCELLA);
		super.setResource(resource);
	}

	@Override
	protected SapOrdenCan doRead() throws Exception {
		SapOrdenCan entity = null;
		try {
			entity = super.doRead();
		} catch (Exception e) {
			this.isError = true;
			throw e;
		}
		if (entity != null) {
			entity.setNu_id_archivo(this.idArchivo);
		}
		return entity;
	}

}
