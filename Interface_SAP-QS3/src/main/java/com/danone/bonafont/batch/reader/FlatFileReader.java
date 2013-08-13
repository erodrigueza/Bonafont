/**
 * 
 */
package com.danone.bonafont.batch.reader;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.core.io.Resource;

import com.danone.bonafont.batch.dto.OrdenDTO;

/**
 * @author Eduardo Rodriguez Wrapper class by reader the inputs files
 */
public class FlatFileReader extends FlatFileItemReader<OrdenDTO> {

	private static final Logger LOG = Logger.getLogger(FlatFileReader.class);
	private Resource resource;
	private boolean isError = false;

	@Override
	public void setResource(Resource resource) {
		LOG.debug("File Name: " + resource.getFilename());
		this.resource = resource;
		super.setResource(resource);
	}

	@Override
	protected void doClose() throws Exception {
		super.doClose();
		moveFile();
	}

	@Override
	protected OrdenDTO doRead() throws Exception {
		try {
			return super.doRead();
		} catch (Exception e) {
			this.isError = true;
			throw e;
		}
	}

	private void moveFile() throws IOException {
		if (resource != null && resource.getFile().exists()) {
			File file = resource.getFile();
			String parent = file.getParent();
			String newParent = parent.substring(0, parent.length() - 3)
					+ (this.isError?"error\\":"processed\\");
			if (file.renameTo(new File(newParent + file.getName()))) {
				LOG.info("OK Move File " + newParent + file.getName() );
			} else {
				LOG.error("FAILED Move File ");
			}
		}
	}
	
}
