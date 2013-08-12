package com.danone.batch;

import org.springframework.batch.core.ItemReadListener;

public class SaludoListenerRead implements ItemReadListener<SaludoInput> {

	@Override
	public void afterRead(SaludoInput arg0) {
		// TODO Auto-generated method stub
		System.err.println("\t\tafterRead..");
	}

	@Override
	public void beforeRead() {
		// TODO Auto-generated method stub
		System.err.println("\t\tbeforeRead..");
	}

	@Override
	public void onReadError(Exception arg0) {
		// TODO En este punto se debe de registrar que ocurrio un error al leer el archivo
		System.err.println("onReadError..");
	}

}
