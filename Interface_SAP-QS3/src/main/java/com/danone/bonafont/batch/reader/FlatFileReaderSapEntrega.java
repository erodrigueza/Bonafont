package com.danone.bonafont.batch.reader;

import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;

import com.danone.bonafont.batch.model.SapEntrega;
import com.danone.bonafont.batch.util.Constants;

/**
 * @author Eduardo Rodriguez 
 * Wrapper class by reader the inputs files
 */
public class FlatFileReaderSapEntrega extends FlatFileReader<SapEntrega> {

	private static final Logger LOG = Logger.getLogger(FlatFileReaderSapEntrega.class);

	@Override
	public void setResource(Resource resource) {
		super.setResource(resource, Constants.SAP_QS3_DELIVERY);
	}

	@Override
	protected SapEntrega doRead() throws Exception {
		SapEntrega entity = null;
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
