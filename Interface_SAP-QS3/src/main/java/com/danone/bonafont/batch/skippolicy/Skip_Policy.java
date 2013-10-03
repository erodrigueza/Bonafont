/**
 * 
 */
package com.danone.bonafont.batch.skippolicy;

import org.apache.log4j.Logger;
import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.file.FlatFileParseException;

/**
 * @author Eduardo Rodriguez
 * 
 */
public class Skip_Policy implements SkipPolicy {

	private static final Logger LOG = Logger.getLogger(Skip_Policy.class);

	@Override
	public boolean shouldSkip(Throwable t, int skipCount)
			throws SkipLimitExceededException {

		if (t.getClass().equals(FlatFileParseException.class)) {
			LOG.error("Ocurrio una exception " + t.getClass());
			LOG.error("Se evitara esta exception para continuar con el proceso.");
			return true;
		}
		return false;
	}

}
