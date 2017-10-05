package com.opensam.ft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RoundStringAm {

	public static void main(String[] args) {
		System.out.println(isRound("aba", "aab"));
		System.out.println(isConsecutive("1111111", "10000000"));
	}

	public static int isRound(String first, String second) {
		int result = -1;

		if (first == null || second == null || first.equals("") || second.equals("")
				|| first.length() != second.length()) {
			return result;
		} else if (first.equals(second)) {
			result = 1;
		}

		else {
			int length = first.length();

			StringBuilder compararerString = new StringBuilder(second);

			for (int i = 1; i < length; i++) {
				compararerString.append(second.substring(i - 1, i));

				if (first.equals(compararerString.toString().substring(i, i + length))) {
					result = 1;
					break;
				}
			}
		}

		return result;

	}

	public static int isConsecutive(String first, String second) {
		int result = -1;

		if (first == null || second == null || first.equals("") || second.equals("")) {
			return result;
		} else {
			Map<Character, String> hexCodeToMap = new HashMap<Character, String>();

			hexCodeToMap.put('0', "0000");
			hexCodeToMap.put('1', "0001");
			hexCodeToMap.put('2', "0010");
			hexCodeToMap.put('3', "0011");
			hexCodeToMap.put('4', "0100");
			hexCodeToMap.put('5', "0101");
			hexCodeToMap.put('6', "0110");
			hexCodeToMap.put('7', "0111");
			hexCodeToMap.put('8', "1000");
			hexCodeToMap.put('9', "1001");
			hexCodeToMap.put('A', "1010");
			hexCodeToMap.put('B', "1011");
			hexCodeToMap.put('C', "1100");
			hexCodeToMap.put('D', "1101");
			hexCodeToMap.put('E', "1110");
			hexCodeToMap.put('F', "1111");

			StringBuilder firstString = new StringBuilder();
			StringBuilder secondString = new StringBuilder();

			int firstStrLength = first.length();
			int secondStrLength = second.length();

			for (int i = 0; i < firstStrLength; i++) {
				firstString.append(hexCodeToMap.get(first.charAt(i)));
			}

			for (int i = 0; i < secondStrLength; i++) {
				secondString.append(hexCodeToMap.get(second.charAt(i)));
			}
			
			
			if(addOne(firstString).equals(secondString.toString()) || addOne(secondString).equals(firstString.toString())){
				return 1;
			} else {
				return -1;
			}
		}

	}

	private static String addOne(StringBuilder input) {
		StringBuilder firstString = new StringBuilder(input);
		int currIndex = firstString.length() - 1;
		System.out.println("got : "+firstString.toString());
		
		while(currIndex >=0 && firstString.charAt(currIndex) == '1'){
			firstString.replace(currIndex, currIndex + 1, "0");
			currIndex--;
		}
		
		if(currIndex>=0){
			firstString.replace(currIndex, currIndex + 1, "1");
		} else {
			firstString.append("1", 0, 0);
		}
		
        Queue<String> list = new LinkedList<String>();
        list.addAll(new ArrayList<String>());

		Set<Integer> set = new LinkedHashSet<>();
		
		set.iterator().next();
				
		Object object =new Object();
		
		Queue<String> queue = new LinkedList<>();
		
				
		System.out.println("got : "+firstString.toString());
		
		return firstString.toString();
		
	}

}
