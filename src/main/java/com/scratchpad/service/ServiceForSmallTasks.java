package com.scratchpad.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ServiceForSmallTasks {

	public void convertHexToInt() {
		String [] input = new String[]{"F9BF","6996","F81F","F99E","EBD7","9669","9FF6","9FF9","BDBD"};
		for(String in : input){
			System.out.println(Integer.parseInt(in,16));
		}
		ArrayList<Test> temporalRow = new ArrayList<Test>();
		temporalRow.clear();
		Test t = new Test();
		t.i = 5;
		temporalRow.add(t);
		System.out.println(temporalRow.get(0).i);
		t.i = 6;
		System.out.println(temporalRow.get(0).i);
		String digitsWithOutComma = "1000";
		StringBuilder str = new StringBuilder(digitsWithOutComma);
		str.setCharAt(1, ',');
	}
		
	
}

class Test {
	public int i;
}