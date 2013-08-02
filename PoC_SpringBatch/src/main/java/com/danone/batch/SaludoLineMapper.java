package com.danone.batch;
import org.springframework.batch.item.file.LineMapper;


public class SaludoLineMapper implements LineMapper<String> {

	@Override
	public String mapLine(String line, int lineNumber) throws Exception {
		return "Hola <"+line+"> !";
	}

}
