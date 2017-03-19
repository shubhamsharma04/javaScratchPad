package com.scratchpad.service;

public class ArrayHelper {
	
	public static void process(){
		 String arr[] = {"M3", "M4", "M5", "M6", "X5M", "M750Li"};
	      String stockElements[] = {"BMW M2 Coupé","BMW M3 Sedan", "BMW M4 Coupé", "BMW M5 Sedan","BMW M6 Gran Coupé", "BMW X5 M", "BMW X6 M", "M 750Li"};   
	      int size = 7;
	      printArrayQuantities(arr);
	      System.out.println(getRandomElement(arr));
	      String [] output = getRandomArray(size, stockElements);
	      printArrayQuantities(output);
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
