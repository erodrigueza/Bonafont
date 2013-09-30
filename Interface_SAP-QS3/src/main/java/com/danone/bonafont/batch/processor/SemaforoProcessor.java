package com.danone.bonafont.batch.processor;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

import com.danone.bonafont.batch.model.Archivo;
import com.danone.bonafont.batch.model.Semaforo;

/**
 * @author Eduardo Rodriguez
 *
 */
public class SemaforoProcessor implements ItemProcessor<Archivo, Semaforo> {

	private static final Logger LOG = Logger.getLogger(SemaforoProcessor.class);
	
	@Override
	public Semaforo process(Archivo file) throws Exception {
		Semaforo semaforo = new Semaforo();
		Date last = file.getDa_registro();
		Calendar when = Calendar.getInstance();
		when.add(Calendar.MINUTE, -30);
		if(last.after(when.getTime())){
			semaforo.setNu_estatus(0);
			semaforo.setCh_descripcion("Archivo SAP OK");
		}else{
			semaforo.setNu_estatus(1);
			semaforo.setCh_descripcion("No hay archivos de SAP en la bandeja de entrada");
			LOG.error("No hay archivos de SAP en la bandeja de entrada.");
			sendMail();
		}
		semaforo.setDa_fecha(new Date());
		return semaforo;
	}
	
	private void sendMail(){
		LOG.info("Envio de mail por no existir archivos en bandeja de entrada.");
	}
}
