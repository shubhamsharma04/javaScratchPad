package com.opensam.ft;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MinPlatform {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++){
			int n = sc.nextInt();
			int [] avr = new int[n];
			int [] dep = new int[n];
			
			for(int j = 0;j<n;j++){
				avr[j] = sc.nextInt();
			}
			
			for(int j = 0;j<n;j++){
				dep[j] = sc.nextInt();
			}
			
			calculateMinimuPlatforms(avr,dep);
		}
	}

	private static void calculateMinimuPlatforms(int[] avr, int[] dep) {
		int max = 0;
		int result = Integer.MIN_VALUE;
		Queue<Integer> pq = new PriorityQueue<Integer>();
		int length = avr.length;
		
		for(int i=0;i<length;i++){
			Integer minDepTime = pq.peek();
			
			if(minDepTime != null && minDepTime < avr[i]){
				while(!pq.isEmpty() && pq.peek() < avr[i]){
					pq.remove();
					max--;
				}
			} 
			
			max++;
			pq.add(dep[i]);
			
			if(max > result){
				result = max;
			}
		}
		
		System.out.println(result);
	}

}
