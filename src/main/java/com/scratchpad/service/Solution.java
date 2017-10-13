package com.scratchpad.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		int [] input = new int[]{3,1,2,2,1,3};
		long result = maxPoints(input);
			System.out.println(result);
		
	}

	static int[] rearrange(int[] elements) {
		if (elements == null || elements.length == 0) {
			return elements;
		} else {
			
			Map<Integer, List<Integer>> sortedMap = new TreeMap<Integer, List<Integer>>();

			for (int i : elements) {
				int bitCount = Integer.bitCount(i);
				sortedMap.computeIfAbsent(bitCount, k -> new ArrayList<>());
				sortedMap.get(bitCount).add(i);
			}

			int[] result = new int[elements.length];

			int index = 0;
			
			for (Map.Entry<Integer, List<Integer>> entry : sortedMap.entrySet()) {
				List<Integer> sortedElementList = entry.getValue();
				Collections.sort(sortedElementList);
				
				int size = sortedElementList.size();
				
				for(int i=0; i< size;i++){
					result[index++] = sortedElementList.get(i);
				}
			}
			
			return result;
		}

	}
	
	static long maxPoints(int[] elements) {

		if(elements == null || elements.length ==0 ){
			return 0;
		} else {
			
			Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>();
			SortedSet<Integer> uniqueElements = new TreeSet<>();
			
			for(int i : elements){
				sortedMap.computeIfAbsent(i, k-> 0);
				sortedMap.put(i, sortedMap.get(i) + i);
				uniqueElements.add(i);
			}
			
			int numberUniqueElements = uniqueElements.size();
			
			int [] sumArr = new int[numberUniqueElements+2];
			
			int index = 1;
			
			for(int i : uniqueElements){
				index++;
				
				int contribution = sortedMap.get(i);
				int priorContribution = sortedMap.get(i - 1)==null ? 0 : sortedMap.get(i - 1);
				int nextContribution = sortedMap.get(i + 1)==null ? 0 : sortedMap.get(i + 1);
				
				int missedCont = priorContribution + nextContribution;
					
					if(contribution < missedCont){
						sumArr[index] = contribution;
					} else {
						sumArr[index] = sumArr[index - 2] + contribution;
					}

			}
			
			return sumArr[numberUniqueElements + 1];
		}

    }

}
