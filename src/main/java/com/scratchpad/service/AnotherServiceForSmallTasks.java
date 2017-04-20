package com.scratchpad.service;

import org.springframework.stereotype.Service;

@Service
public class AnotherServiceForSmallTasks {

	public void performTaks() {
		char ch1 = 88;
		System.out.println("Ch1 is " + ch1);

	    ch1=(char) (ch1+1);
	    ch1++;
	    System.out.println("ch1 is "+ch1);
	}

	
}
