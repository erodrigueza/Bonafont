package com.danone.batch;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class SaludoListenerChunk implements ChunkListener {

	@Override
	public void afterChunk(ChunkContext arg0) {
		// TODO Auto-generated method stub
		System.err.println("\t<<<<<<<<<<<<<afterChunk>>>>>>>>>");
	}

	@Override
	public void afterChunkError(ChunkContext arg0) {
		// TODO Auto-generated method stub
		System.err.println("afterChunkError");
	}

	@Override
	public void beforeChunk(ChunkContext arg0) {
		// TODO Auto-generated method stub
		System.err.println("\n\t<<<<<<<beforeChunk>>>>>>>>>");
	}

}
