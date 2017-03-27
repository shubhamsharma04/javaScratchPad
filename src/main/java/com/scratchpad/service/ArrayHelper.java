package com.scratchpad.service;

import java.util.HashMap;
import java.util.Map;

public class ArrayHelper {
	
	public static void process(){
		 String arr[] = {"M3", "M4", "M5", "M6", "X5M", "M750Li"};
	      String stockElements[] = {"BMW M2 Coupé","BMW M3 Sedan", "BMW M4 Coupé", "BMW M5 Sedan","BMW M6 Gran Coupé", "BMW X5 M", "BMW X6 M", "M 750Li"};   
	      int size = 7;
	      printArrayQuantities(arr);
	      System.out.println(getRandomElement(arr));
	      String [] output = getRandomArray(size, stockElements);
	      printArrayQuantities(output);
	      // HASHMAP null test
	      Map<String,String> map = new HashMap<String,String>();
	      map.put("test", null);
	      // String split test;
	      String test = "a,b,c";
	      System.out.println(test.split(",",2)[1]);
	      String a = "a";
	      String b = "b";
	      System.out.println(b.compareTo(a));
	      a = "";
	      String [] temp = a.split(",");
	      System.out.println(temp.length);
	      StringBuilder s=new StringBuilder("abcd");
	      s.deleteCharAt(0);
	      final String sample = "F5824B    C2112-----201801201510*00 ";
	      System.out.println(sample.substring(8, 10));
	}
	
	 public static void printArrayQuantities(String[] arr){
	      int num[] = {2, 1, 3, 3, 5, 1};

	      for( int i = 0; i < num.length; i++){
	         System.out.println(arr[i] + " " + num[i]);

	      }



	   }
	 public static String getRandomElement(String[] arr){
	      int randomNum = 0 + (int)(Math.random() * 6);
	      return arr[randomNum];


	   }

	   public static String[] getRandomArray(int size, String[] stockElements){
	      String[] randArray = new String[size];
	      for( int i = 0; i < size; i++){

	         randArray[i] = getRandomElement(stockElements);

	      }
	      return randArray;
	   }

}
