package com.danone.bonafont.batch.mail;

import java.io.File;
import java.io.FileFilter;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

/**
 * @author Eduardo Rodriguez
 * 
 */
public class SendMailService {
 
	private static final Logger LOG = Logger.getLogger(SendMailService.class);
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

    public void sendMail(final String message) {
        LOG.info("send Email started");
        
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
            	setRecipients(mimeMessage);
                mimeMessage.setFrom(new InternetAddress(senderAddress));
                mimeMessage.setSubject("Notificación interface SAP-QS3");

                MimeMessageHelper helper;
                
                File directory = new File(attachmentFilePath);
                LOG.debug("Directorio configurado para archivos adjuntos: "+directory);
                LOG.debug("Tamanio del contenido en el directorio: "+directory.length());
                if(directory.length()>0){
                	final File file = directory.listFiles(FILE_FILTER)[0];
                	LOG.info("Archivo enviado por correo: "+file.getName());
                	helper = new MimeMessageHelper(mimeMessage, true);
                	helper.addAttachment(file.getName(), new FileSystemResource(file));
                }else {
                	helper = new MimeMessageHelper(mimeMessage);
                }
                
                helper.setText(message + "\n\nPara mayor detalle consulte el archivo adjunto.");
            }
            private void setRecipients(MimeMessage mimeMessage) throws AddressException, MessagingException{
            	String[] array = recipient.split(";");
           		InternetAddress[] addressTo = new InternetAddress[array.length];
           		for (int i = 0; i < array.length; i++){
           			addressTo[i] = new InternetAddress(array[i]);
           		}
           		mimeMessage.setRecipients(Message.RecipientType.TO, addressTo);
            }
        };
        try {
            this.mailSender.send(preparator);
            LOG.info("send Email completed");
        } catch (MailException ex) {
            LOG.error("send Email failed", ex);
        }
    }
 
    public static FileFilter FILE_FILTER = new FileFilter() {
        public boolean accept(File file) {
            return !file.isDirectory();
        }
    };
    
 }