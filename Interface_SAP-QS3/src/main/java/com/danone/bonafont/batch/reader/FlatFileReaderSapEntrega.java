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
		LOG.debug("File Name: " + resource.getFilename());
		super.resource = resource;
		super.idArchivo = super.archivoDAO.registerFile(resource.getFilename(),
				Constants.ARCHIVO_LEIDO, Constants.SAP_QS3_DELIVERY);
		super.setResource(resource);
	}

	@Override
	protected SapEntrega doRead() throws Exception {
		SapEntrega entity = null;
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
