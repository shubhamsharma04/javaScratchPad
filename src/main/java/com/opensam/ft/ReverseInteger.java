package com.opensam.ft;

public class ReverseInteger {

	public static void main(String[] args) {
		int input = 1563847412;
		boolean output = isPalindrome(-2147483648);
		System.out.println(output);
	}
	
	private static int reverse(int x) {
        System.out.println(x);
        long sign = (x >= 0 ? 1 : -1);
        
        long y = x*sign;
        
        StringBuilder valAsString = new StringBuilder(String.valueOf(y));
        long valAsLong = Long.valueOf(valAsString.reverse().toString());
        
        if(valAsLong >= Integer.MAX_VALUE || valAsLong < Integer.MIN_VALUE){
            return 0;
        } else {
            return  (int) ((int)sign * valAsLong);
        }
    }
	
	private static boolean isPalindrome(int x) {
        long sign = x>=0 ? 1 : -1;
        
        long y = x * sign;
        int size = getSizeOfInt(y);
        
        int end = size - 1;
        int start=0;
        boolean isPalindrome = true;
        
        while(start < end){
            if(getDigit(y,end) != getDigit(y,start)){
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
               
        return isPalindrome;
    }
    
    private static int getSizeOfInt(long y){
        if(y==0){
            return 0;
        } else {
        
        int size = 0;
        
        while(y != 0){
            size++;
            y /=10;
        }
        
        return size;
        }
    }
               
    private static int getDigit(long digit, int index){
        return (int) ((digit/Math.pow(10,index))%10);
    }

}
