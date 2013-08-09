package com.danone.batch;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	new ClassPathXmlApplicationContext("launch-context.xml");
    }
}