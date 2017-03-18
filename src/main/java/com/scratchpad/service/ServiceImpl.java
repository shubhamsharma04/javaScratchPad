package com.scratchpad.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scratchpad.dataformat.NNStat;

@Service
public class ServiceImpl {

	public void sortStats() throws IOException {
		List<String> statsAsString = FileUtils.readLines(new File("statsfull.json"),
				StandardCharsets.UTF_8);
		List<NNStat> stats = new ArrayList<NNStat>();
		ObjectMapper mapper = new ObjectMapper();
		for (String stat : statsAsString) {
			NNStat nnStat = mapper.readValue(stat, NNStat.class);
			stats.add(nnStat);
		}
		Collections.sort(stats);
		for (NNStat stat : stats) {
			System.out.println(stat.getAsJson(stat));
		}
	}

	public void arrayHop() {
		int input[] = new int[]{0,0,0};
		
		int size = input.length;
        int [] hopCountArr = new int[size];
        int [] pathArr = new int[size];
        for(int i=1;i<size;i++){
            hopCountArr[i]=Integer.MAX_VALUE;
        }
        
        for(int i=0;i<size-1;i++){
            int numOfHops = hopCountArr[i] + 1;
            int hopCapacity = input[i];
            for(int j=1;j<=hopCapacity && i+j<size;j++){
                if(numOfHops<hopCountArr[i+j]){
                    hopCountArr[i+j] = numOfHops;
                    pathArr[i+j] = i;
                }
            }
        }
        int pathIndex = size-1;
        StringBuilder result = new StringBuilder();
        result.append("out");
        result.append(",");
        result.append(pathIndex);
        while(pathIndex!=0){
        result.append(",");
        result.append(pathArr[pathIndex]);
        pathIndex =  pathArr[pathIndex];   
        }
        System.out.println(result.reverse().toString());
	}

	public void breakString() {
		String str = "NC43-EB2;49.21716;-122.667252;49.216757;-122.666235";
		// Will break str to "NC43-EB2" and "49.21716" "-122.667252" "49.216757" "-122.666235"
		String [] allValues = str.split(";", -1);
		String [] nameValuePair = allValues[0].split("-");
		// substring selects only the specified portion of string 
		String name = nameValuePair[0].substring(1, 4);
		
		// Since "49.21716" is of type String, we may need it to parse it to data type double if we want to do operations like numeric operations
		double c1 = 0d;
		try {
		c1 = Double.parseDouble(allValues[1]);
		} catch (NumberFormatException e) {
			// TODO: Take corrective measures or simply log the error
		}
	}

	public void exceptionTest() {
		int numOfAvds = 5;
		 for (int i = 0; i < numOfAvds; i++) {
            
                 try {
                     System.out.println("i : "+i);
                     if(i==2){
                     throw new Exception();
                     }
                 } catch (Exception e) {
                    e.printStackTrace();
                    
                 } 
         }
		
	}

}
