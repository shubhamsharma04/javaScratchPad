package com.scratchpad.service;

public class LModelService {
	
	static int [] input = new int[]{11,18,17,15,9,5,12,19,22,25};
	static int [] ouput = new int[]{6,18,17,15,9,5,12,19,22,25};
	
	public static void printModelsOutput() {
		float[] w1 = new float[] { 0.30f, 0.50f };
		double sum = 0d;
		for (int i = 0; i < input.length; i++) {
			float err = (float) Math.pow(ouput[i] - (w1[0] + (w1[1] * input[i])), 2);
			sum += err;
		}
		System.out.println("Total err1 : " + sum);
		sum = 0d;
		w1 = new float[] { 5.75f, 0.04f };
		for (int i = 0; i < input.length; i++) {
			float err = (float) Math.pow(ouput[i] - (w1[0] + (w1[1] * input[i])), 2);
			sum += err;
		}
		System.out.println("Total err2 : " + sum);

		sum = 0d;
		w1 = new float[] { 3.20f, 0.20f };
		for (int i = 0; i < input.length; i++) {
			double err = Math.pow(ouput[i] - (w1[0] + (w1[1] * input[i])), 2);
			sum += err;
		}
		System.out.println("Total err3 : " + sum);

		sum = 0d;
		w1 = new float[] { 8.75f, -0.50f, 0.02f };
		for (int i = 0; i < input.length; i++) {
			float err = (float) Math.pow(ouput[i] - (w1[0] + (w1[1] * input[i]) + (w1[2] * input[i] * input[i])), 2);
			sum += err;
		}
		System.out.println("Total err4 : " + sum);
		
		


	}
	
	

}
