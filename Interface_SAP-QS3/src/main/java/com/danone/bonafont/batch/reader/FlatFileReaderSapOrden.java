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
		super.setResource(resource, Constants.SAP_QS3_OR_CREATION);
	}

	@Override
	protected SapOrden doRead() throws Exception {
		SapOrden entity = null;
		try {
			entity = super.doRead();
		} catch (Exception e) {
			isError = true;
			desError = Constants.ERR_FILE_STRU;
			LOG.error("Error en la estructura de los datos.");
			LOG.error(e);
			throw e;
		}
		if (entity != null) {
			entity.setNu_id_archivo(this.idArchivo);
		}
		return entity;
	}

}
