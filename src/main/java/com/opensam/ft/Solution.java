package com.opensam.ft;

import java.util.Scanner;

public class Solution {
	
	private static final char openParenthesis = '(';
	
	private static final char closeParenthesis = ')';

	public static void stuff() {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
		String inputStr = sc.next().replaceAll(" ", "");
		String [] input = inputStr.split("/");
        String exprTree = input[0];
        StringBuilder result = null;
		if(input.length==1){
			result = new StringBuilder(exprTree);
		} else {
			String seqOperations = input[1];
			
			seqOperations = seqOperations.replaceAll("[R]{2}", "");
			seqOperations = seqOperations.replaceAll("[S]{1,}", "S");
			
			result = new StringBuilder(exprTree);
			int numOfOperations = seqOperations.length();
			
			for(int i=0;i<numOfOperations;i++){
				char ch = seqOperations.charAt(i);
				
				switch(ch){
				
				case 'R':
					result = applyRRule(result);
					break;
					
				case 'S':
					result = applySRule(result);
				}
				
			}
		}
		
		System.out.println(result.toString());
		}
	}

	private static StringBuilder applyRRule(StringBuilder result) {
		StringBuilder revResult = new StringBuilder();
		int length = result.length();
		
		for(int i=length - 1; i>=0; i--){
			char ch = result.charAt(i);
			
			if(ch == openParenthesis){
				revResult.append(closeParenthesis);
			} else if(ch == closeParenthesis){
				revResult.append(openParenthesis);
			} else {
				revResult.append(ch);
			}
		}
		
		return revResult;
	}

	private static StringBuilder applySRule(StringBuilder result) {
		StringBuilder sResult = new StringBuilder();

		char [] chars = result.toString().toCharArray();
		int length = chars.length;
		
		for(int i=0; i < length-1;i++){
			char ch = chars[i];
			char nextChar = chars[i+1];
			
			if(ch==openParenthesis && nextChar != openParenthesis){
				while((nextChar = chars[++i]) != closeParenthesis){
					sResult.append(nextChar);
				}
			} else {
				sResult.append(ch);
			}
		}
		sResult.append(chars[length - 1]);
		
		/*if(result.charAt(0) == (openParenthesis)){
			int endIndex = processForSRule(result);
			String firstExpressionTree = result.substring(0, endIndex);
			
			firstExpressionTree = firstExpressionTree.replaceAll("[()]", "");
						
			sResult.append(firstExpressionTree);
			
			int trailingChars = result.length() - endIndex;
			
			if(trailingChars > 0){
				sResult.append(result.substring(endIndex+1));
			} 
			
			
			
		}*/
		return sResult;
	}

	private int processForSRule(StringBuilder result) {
		int index = 0;
		int openParenCount = 1;
		int closeParenCount = 0;
		
		while(openParenCount != closeParenCount){
			index++;
			char ch = result.charAt(index);
			
			if(ch == openParenthesis){
				openParenCount++;
			} else if(ch == closeParenthesis){
				closeParenCount++;
			}
			
		}
		return index;
	}
	
}
