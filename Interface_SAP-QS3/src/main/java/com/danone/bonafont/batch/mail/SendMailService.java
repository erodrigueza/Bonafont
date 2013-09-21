package com.danone.bonafont.batch.mail;

import java.io.File;
import java.io.FileFilter;

import javax.mail.Message;
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
 
    public void setFields(JavaMailSender mailSender, String senderAddress, String recipient, String attachmentFilePath) {
 
        this.mailSender = mailSender;
        this.senderAddress = senderAddress;
        this.recipient = recipient;
        this.attachmentFilePath = attachmentFilePath;
    }
 
    public void sendMail() {
        LOG.debug("send Email started");
        
        
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                mimeMessage.setFrom(new InternetAddress(senderAddress));
                mimeMessage.setSubject("Notification Interface Sap-Qs3");

                MimeMessageHelper helper;
                
                File directory = new File(attachmentFilePath);
                System.err.println("Directory: "+directory);
                System.err.println("Length: "+directory.length());
                if(directory.length()>0){
                	final File file = directory.listFiles(FILE_FILTER)[0];
                	System.err.println("Archivo: "+file.getName());
                	helper = new MimeMessageHelper(mimeMessage, true);
                	helper.addAttachment(file.getName(), new FileSystemResource(file));
                }else {
                	helper = new MimeMessageHelper(mimeMessage);
                }
                
                helper.setText("Text in Email Body");
            }
        };
        try {
            this.mailSender.send(preparator);
            LOG.debug("send Email completed");
        } catch (MailException ex) {
            LOG.debug("send Email failed", ex);
        }
    }
 
    public static FileFilter FILE_FILTER = new FileFilter() {
        public boolean accept(File file) {
            return !file.isDirectory();
        }
    };
 }