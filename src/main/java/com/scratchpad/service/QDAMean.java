package com.scratchpad.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;

public final class QDAMean {

	public static void getMean() {
		try {
			List<String> input = FileUtils.readLines(new File("temp.txt"), StandardCharsets.UTF_8);
			double l=0d,r=0d;
			int count = 0;
			for(String str : input){
				String [] inp = str.split("\\s{1,}");
				count++;
				l = l + Double.parseDouble(inp[0]);
				r = r + Double.parseDouble(inp[1]);
			}
			System.out.println("Mean : "+(l/count)+" ,,,,  "+(r/count));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
