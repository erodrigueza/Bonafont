/**
 * 
 */
package com.danone.bonafont.batch.listener;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.scope.context.StepContext;
import org.springframework.batch.item.ExecutionContext;

import com.danone.bonafont.batch.util.Constants;

/**
 * @author Eduardo Rodriguez
 * 
 */
public class ChunkErrorListener implements ChunkListener {

	private static final Logger LOG = Logger.getLogger(ChunkErrorListener.class);

	@Override
	public void beforeChunk(ChunkContext context) {
	}

	@Override
	public void afterChunk(ChunkContext context) {
		LOG.debug("Termino correctamente a nivel de Chunk.");
		StepContext stepContext = context.getStepContext();
		StepExecution stepExecution = stepContext.getStepExecution();
		ExecutionContext executionContext = stepExecution.getExecutionContext();
		executionContext.putInt("anErrorHappened", 0);
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		LOG.error("Ocurrio un error a nivel de Chunk.");
		StepContext stepContext = context.getStepContext();
		StepExecution stepExecution = stepContext.getStepExecution();
		ExecutionContext executionContext = stepExecution.getExecutionContext();
		executionContext.putInt("anErrorHappened", 1);

		Exception ex = (Exception) context.getAttribute(ROLLBACK_EXCEPTION_KEY);
		if(ex != null){
			LOG.error("Exception: "+ex.getMessage());
		}
		if(ex instanceof Exception && Constants.ERR_DATA_DUPL.equals(ex.getMessage())){
			executionContext.putString("DescriptionError", ex.getMessage());
		}
		if (ex.getCause() != null) {
			LOG.error("EXCEPTION [" + ex.getCause().getClass().getName() + "]");
			if (ex.getCause().getMessage().contains("Cannot open connection")) {
				stepExecution.setExitStatus(new ExitStatus("EXCEPTION DB"));
			}
		}
	}

}
