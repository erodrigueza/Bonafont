package com.danone.bonafont.batch.reader;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;

import com.danone.bonafont.batch.model.SapOrden;
import com.danone.bonafont.batch.util.Constants;

/**
 * @author Eduardo Rodriguez 
 * Wrapper class by reader the inputs files
 */
public class FlatFileReaderSapOrden extends FlatFileReader<SapOrden> {

	private static final Logger LOG = Logger.getLogger(FlatFileReaderSapOrden.class);

	@Override
	public void setResource(Resource resource) {
		LOG.debug("File Name: " + resource.getFilename());
		super.resource = resource;
		super.idArchivo = super.archivoDAO.registerFile(resource.getFilename(),
				Constants.ARCHIVO_LEIDO, Constants.SAP_QS3_OR_CREATION);
		super.setResource(resource);
	}

	@Override
	protected SapOrden doRead() throws Exception {
		SapOrden entity = null;
		try {
			entity = super.doRead();
		} catch (Exception e) {
			isError = true;
			desError = Constants.ERR_FILE_STRU;
			throw e;
		}
		if (entity != null) {
			entity.setNu_id_archivo(this.idArchivo);
		}
		return entity;
	}

}
