package com.danone.bonafont.batch;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("launch-context.xml");
	}

}
