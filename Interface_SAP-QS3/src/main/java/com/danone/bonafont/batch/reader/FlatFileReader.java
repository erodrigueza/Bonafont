package com.danone.bonafont.batch.reader;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.core.io.Resource;

import com.danone.bonafont.batch.dao.ArchivoDAO;
import com.danone.bonafont.batch.dto.OrdenInputDTO;
import com.danone.bonafont.batch.util.Constants;

/**
 * @author Eduardo Rodriguez 
 * Wrapper class by reader the inputs files
 */
public class FlatFileReader extends FlatFileItemReader<OrdenInputDTO> {

	private static final Logger LOG = Logger.getLogger(FlatFileReader.class);
	private Resource resource;
	private boolean isError = false;
	private Integer idArchivo;

	@javax.annotation.Resource
	ArchivoDAO archivoDAO;

	@Override
	public void setResource(Resource resource) {
		LOG.debug("File Name: " + resource.getFilename());
		this.resource = resource;
		this.idArchivo = archivoDAO.registerFile(resource.getFilename(),
				Constants.ARCHIVO_LEIDO, Constants.SAP_QS3_OR_CREATION);
		super.setResource(resource);
	}

	@Override
	protected void doClose() throws Exception {
		super.doClose();
		moveFile();
	}

	@Override
	protected OrdenInputDTO doRead() throws Exception {
		OrdenInputDTO dto = null;
		try {
			dto = super.doRead();
		} catch (Exception e) {
			this.isError = true;
			throw e;
		}
		if (dto != null) {
			dto.setNu_id_archivo(this.idArchivo);
		}
		return dto;
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

	@Override
	public void update(ExecutionContext executionContext)
			throws ItemStreamException {
		if (executionContext.get("anErrorHappened") != null) {
			this.isError = executionContext.getInt("anErrorHappened") == 1;
		}
		super.update(executionContext);
	}

}
