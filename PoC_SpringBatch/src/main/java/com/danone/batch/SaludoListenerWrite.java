package com.danone.batch;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

public class SaludoListenerWrite implements ItemWriteListener<SaludoInput> {

	@Override
	public void afterWrite(List<? extends SaludoInput> arg0) {
		// TODO Auto-generated method stub
		System.err.println("\t\tafterWrite");
	}

	@Override
	public void beforeWrite(List<? extends SaludoInput> arg0) {
		// TODO Auto-generated method stub
		System.err.println("\t\tbeforeWrite");
	}

	@Override
	public void onWriteError(Exception arg0, List<? extends SaludoInput> arg1) {
		// TODO Auto-generated method stub
		System.err.println("errorWrite");
	}

}
