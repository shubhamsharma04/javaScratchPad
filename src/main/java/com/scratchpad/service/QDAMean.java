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
	
	public static int bsearch(int[] arr, int key, int lo, int hi) {
	    while (lo <= hi) {
	        int mid = (lo + hi) / 2;
	        if (arr[mid] == key) {
	            System.out.println("The value " + key + " is found at " + mid);
	            int higherResult = bsearch(arr, key, mid + 1, hi);
	            if (higherResult < 0) {
	                return mid;
	            }
	            return higherResult;
	        }
	        if (arr[mid] < key) {
	            lo = mid + 1;
	        } else {
	            hi = mid - 1;
	        }
	    }
	    return -1;
	}

}
