package com.danone.batch;

import java.util.Properties;

import org.springframework.batch.item.ItemProcessor;

/* Class to implement ItemProcessor in this case aggregate the correct phrase */
public class SaludoItemProcessor implements ItemProcessor<SaludoInput, SaludoInput> {
	
	private Properties template;

	public Properties getTemplate() {
		return template;
	}

	public void setTemplate(Properties template) {
		this.template = template;
	}

	@Override
	public SaludoInput process(SaludoInput saldo) throws Exception {
//		saldo.saludar( template );
		System.err.println("\t\t\tColumna 1: "+saldo.getNombre() + " Columna 2:"+saldo.getIdioma());
		return saldo;
	}

}
