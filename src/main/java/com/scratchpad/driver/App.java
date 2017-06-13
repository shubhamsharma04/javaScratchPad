package com.scratchpad.driver;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scratchpad.service.QDAMean;

public class App {
	 
	final static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		QDAMean.getMean();
	}
}
