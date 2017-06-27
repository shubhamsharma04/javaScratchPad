package com.opensam.ft;

import java.util.Arrays;
import java.util.Stack;

public class GBalanceString {

	public void balanceIt() {
		String testString = "(ab()";
		int length = testString.length();
		char [] output = new char[length];
		Arrays.fill(output, '\n');
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
			if(output[i]!='\n'){
				System.out.print(output[i]);
			}
		}
	}
	
	

}
