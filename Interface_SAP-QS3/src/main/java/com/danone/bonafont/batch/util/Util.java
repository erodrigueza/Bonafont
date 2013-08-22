package com.danone.bonafont.batch.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.danone.bonafont.batch.reader.FlatFileReader;

/**
 * @author Eduardo Rodriguez Utility Class
 */
public class Util {

	private static final Logger LOG = Logger.getLogger(FlatFileReader.class);

	public static void executeCommand(String command) throws IOException {

		final Process pr = Runtime.getRuntime().exec(command);

		new Thread(new Runnable() {
			public void run() {
				try {
					BufferedReader br_in = new BufferedReader(
							new InputStreamReader(pr.getInputStream()));
					String buff = null;
					while ((buff = br_in.readLine()) != null) {
						LOG.info(buff);
						try {
							Thread.sleep(100);
						} catch (Exception e) {
						}
					}
					br_in.close();
				} catch (IOException ioe) {
					LOG.error("Exception caught printing process output.");
					ioe.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				try {
					BufferedReader br_err = new BufferedReader(
							new InputStreamReader(pr.getErrorStream()));
					String buff = null;
					while ((buff = br_err.readLine()) != null) {
						LOG.info(buff);
						try {
							Thread.sleep(100);
						} catch (Exception e) {
						}
					}
					br_err.close();
				} catch (IOException ioe) {
					LOG.error("Exception caught printing process error.");
					ioe.printStackTrace();
				}
			}
		}).start();

	}

	public static void main(String[] args) {
		try {
			Util.executeCommand("cmd /c move C:\\interface_SAP_QS3\\data\\in\\orderCreation\\new\\firstOut.txt C:\\interface_SAP_QS3\\data\\in\\orderCreation\\error & exit");
		} catch (IOException e) {
			LOG.error(e.getLocalizedMessage());
		}
	}
	
	public static String getDate(){
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	    return formatter.format(new Date());
	}

}
