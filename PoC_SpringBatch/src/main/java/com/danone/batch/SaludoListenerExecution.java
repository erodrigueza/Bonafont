package com.danone.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class SaludoListenerExecution implements StepExecutionListener {

	@Override
	public ExitStatus afterStep(StepExecution arg0) {
		// TODO Auto-generated method stub
		System.err.println("--------------afterStep--------------");
		return null;
	}

	@Override
	public void beforeStep(StepExecution arg0) {
		// TODO Auto-generated method stub
		System.err.println("--------------beforeStep--------------");
	}

}
