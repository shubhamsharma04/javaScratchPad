package com.scratchpad.service;

public class LModelService {
	
	static int [] input = new int[]{11,18,17,15,9,5,12,19,22,25};
	static int [] ouput = new int[]{6,8,10,4,9,6,3,5,2,10};
	
	public static void printModelsOutput() {
		double[] w1 = new double[] { 0.30d, 0.50d };
		double sum = 0d;
		for (int i = 0; i < input.length; i++) {
			float err = (float) Math.pow(ouput[i] - (w1[0] + (w1[1] * input[i])), 2);
			sum += err;
		}
		System.out.println("Total err1 : " + sum);
		sum = 0d;
		w1 = new double[] { 5.75d, 0.04d };
		for (int i = 0; i < input.length; i++) {
			float err = (float) Math.pow(ouput[i] - (w1[0] + (w1[1] * input[i])), 2);
			sum += err;
		}
		System.out.println("Total err2 : " + sum);

		sum = 0d;
		w1 = new double[] { 3.20d, 0.20d };
		for (int i = 0; i < input.length; i++) {
			double err = Math.pow(ouput[i] - (w1[0] + (w1[1] * input[i])), 2);
			sum += err;
		}
		System.out.println("Total err3 : " + sum);

		sum = 0d;
		w1 = new double[] { 8.75d, -0.50d, 0.02d };
		for (int i = 0; i < input.length; i++) {
			double err = (float) Math.pow(ouput[i] - (w1[0] + (w1[1] * input[i]) + (w1[2] * input[i] * input[i])), 2);
			sum += err;
		}
		System.out.println("Total err4 : " + sum);
		double [] logSize = new double[]{2.18d,1.09d,-.37d,0d,-0.42d,0.09d,-0.48d,0.62d,0.57d,0.44d};
		double [] dis = new double[]{0.01d,18.30d,3.00d,4.10d,9.00d,7.20d,10.00d,2.70d,2.80d,0.01d};
		w1 = new double[] { 1.05d, -0.52d, 0.85d };
		for(int i =0;i<logSize.length;i++){
			double err = (double) (w1[0]+w1[1]*logSize[i]+w1[2]*dis[i]);
			err = sigmoid(err);
			System.out.printf(i+" : %f",err);//w1[0]+w1[1]*logSize[i]+w1[2]*dis[i]);
			String result = Double.compare(err, 0.5d)>=0?"1":"0";
			System.out.println(i+" : "+result);
			
		}


	}

	private static double sigmoid(double err) {
		
		return 1/(1+Math.exp(-err));
	}
	
	

}
