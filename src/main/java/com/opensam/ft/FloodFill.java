package com.opensam.ft;

import java.util.Scanner;

public class FloodFill {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int i = 0;i<t;i++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int [][] input = new int[N][M];
			
			for(int j = 0;j<N;j++){
				for(int k=0;k<M;k++){
					input[j][k] = sc.nextInt();
				}
			}
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			int color = sc.nextInt();
			
			floodFill(input,x,y,color);
			for(int j = 0;j<N;j++){
				for(int k=0;k<M;k++){
					System.out.print(input[j][k] +" ");
				}
			}
			System.out.println();
		}
	}

	private static void floodFill(int[][] input, int x, int y, int color) {
		int prevColor = input[x][y];
		input[x][y] = color;
		
		if( x > 0 && y > 0 && input[x - 1][y - 1] == prevColor){
			
				floodFill(input, x- 1, y - 1,color);
			
			
		}
		
		if(x > 0 && input[x - 1][y] == prevColor)
			floodFill(input, x- 1, y,color);
		
		if( y > 0 && input[x][y - 1] == prevColor)
			floodFill(input, x, y - 1,color);
		
		if(x < input.length - 1 && y < input[0].length - 1 && input[x + 1][y + 1] == prevColor){
				floodFill(input, x + 1, y + 1,color);
		
		}
		
		if(x < input.length - 1 && input[x + 1][y] == prevColor)
			floodFill(input, x + 1, y,color);
		
		if(y < input[0].length - 1 && input[x][y + 1] == prevColor)
			floodFill(input, x, y + 1,color);
		
		if(x > 0 && y < input[0].length - 1 && input[x - 1][y+1] == prevColor)
			floodFill(input, x - 1, y + 1,color);
		
		if(x < input.length - 1 && y > 0 && input[x + 1][y-1] == prevColor)
			floodFill(input, x + 1, y - 1,color);
	}

}
