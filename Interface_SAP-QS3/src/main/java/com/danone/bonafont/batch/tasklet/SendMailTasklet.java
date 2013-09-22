package com.danone.bonafont.batch.tasklet;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.danone.bonafont.batch.mail.SendMailService;

/**
 * @author Eduardo Rodriguez
 * Tasklet responsable de enviar mail de notificacion
 */
public class SendMailTasklet implements Tasklet {

	private static final Logger LOG = Logger.getLogger(SendMailTasklet.class);
	private SendMailService sendMailService = new SendMailService();
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}	

	public void setSendMailService(SendMailService sendMailService) {
		this.sendMailService = sendMailService;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		LOG.info("inicia SendMailTasklet...");
		sendMailService.sendMail(message);
		LOG.info("termina correctamente SendMailTasklet...");
		return RepeatStatus.FINISHED;
	}

}
