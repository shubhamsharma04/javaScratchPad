package com.opensam.ft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class GBalanceString {

	public void balanceIt() {
		String testString = "(ab()";
		char fillhar = '\n';
		int length = testString.length();
		char [] output = new char[length];
		Arrays.fill(output, fillhar);
		char openBraces = '(';
		char closeBraces = ')';
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < length; i++) {
			char currChar = testString.charAt(i);
			if (currChar == openBraces) {
				stack.push(i);
			} else if (currChar == closeBraces && !stack.isEmpty()) {
				output[i] = closeBraces;
				output[stack.pop()] = openBraces;
			} else {
				output[i] = currChar;
			}
		}
		for (int i = 0; i < length; i++) {
			if(output[i]!=fillhar){
				System.out.print(output[i]);
			}
		}
	}

	public void topNNums() {
		int [] input = new int []{1,1,1,2,3,1,3,3,4,5,5};
		int n = 3;
		Map<Integer,Integer> freqMap = new HashMap<Integer,Integer>();
		for(int i : input){
			if(freqMap.containsKey(i)){
				freqMap.put(i, freqMap.get(i)+1);
			} else {
				freqMap.put(i, 1);
			}
		}
		Map<Integer,Integer> fMap = new TreeMap<Integer,Integer>();
		for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
			fMap.put(-1*entry.getValue(), entry.getKey());
		}
		int count = 0;
		for(Map.Entry<Integer,Integer> entry : fMap.entrySet()){
			if(count==n){
				break;
			}
			System.out.println(entry.getValue());
			count++;
		}
	}
	
	

}
