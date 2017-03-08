package com.scratchpad.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceForSmallTasks {

	public void convertHexToInt() {
		String [] input = new String[]{"F9BF","6996","F81F","F99E","EBD7","9669","9FF6","9FF9","BDBD"};
		for(String in : input){
			System.out.println(Integer.parseInt(in,16));
		}
	}

	
	
}
