package com.danone.bonafont.batch.tasklet;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.mail.javamail.JavaMailSender;

import com.danone.bonafont.batch.mail.SendMailService;

/**
 * @author Eduardo Rodriguez
 * 
 */
public class SendMailTasklet implements Tasklet {

	private static final Logger LOG = Logger.getLogger(SendMailTasklet.class);
	private SendMailService sendMailService = new SendMailService();
	private JavaMailSender mailSender;
	private String senderAddress;
	private String recipient;
	private String attachmentFilePath;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public void setAttachmentFilePath(String attachmentFilePath) {
		this.attachmentFilePath = attachmentFilePath;
	}

	public void setSendMailService(SendMailService sendMailService) {
		this.sendMailService = sendMailService;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		LOG.debug("execute(StepContribution contribution, ChunkContext chunkContext) begin");
		sendMailService.setFields(mailSender, senderAddress, recipient,
				attachmentFilePath);
		sendMailService.sendMail();
		LOG.debug("execute(StepContribution contribution, ChunkContext chunkContext) end");
		return RepeatStatus.FINISHED;
	}
}
