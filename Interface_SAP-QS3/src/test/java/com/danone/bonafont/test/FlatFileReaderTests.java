package com.danone.bonafont.test; 

import com.danone.bonafont.batch.reader.FlatFileReader;

import junit.framework.TestCase;

public class FlatFileReaderTests extends TestCase {

	private FlatFileReader reader = new FlatFileReader();
	
	public void testReadOnce() throws Exception {
		assertEquals("Hello world!", reader.read());
	}

	public void testReadTwice() throws Exception {
		reader.read();
		assertEquals(null, reader.read());
	}

}
