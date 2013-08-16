package com.danone.batch;

import java.util.Properties;

import org.springframework.batch.item.ItemProcessor;

/* Class to implement ItemProcessor in this case aggregate the correct phrase */
public class SaludoItemOutProcessor implements ItemProcessor<SaludoInput, String> {
	
	private Properties template;

	public Properties getTemplate() {
		return template;
	}

	public void setTemplate(Properties template) {
		this.template = template;
	}

	@Override
	public String process(SaludoInput saludo) throws Exception {
		System.out.println(saludo.getNombre() + "," +saludo.getIdioma());
		return saludo.getNombre() + "," +saludo.getIdioma();
	}

}
