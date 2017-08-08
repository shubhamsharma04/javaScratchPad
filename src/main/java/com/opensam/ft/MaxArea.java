package com.opensam.ft;

public class MaxArea {
	
	public int maxArea(int[] a) {
        int length = a.length;
        if(length < 2){
            return 0;
        } else {
            
            int minIndex = a[0]< a[1] ? 0 : 1;
            int maxIndex = minIndex ^ 1;
            int sum = a[minIndex];
            
            for(int i=2; i< length;i++){
        
                if( a[i] < a[minIndex] ){
                  
                    if(a[ i ] * (i - maxIndex) > sum){
                        minIndex = i;
                        sum = a[minIndex] * (i - maxIndex);
                    
                    } else if(a[i] * (i - minIndex) > sum){
                       maxIndex = i;
                       sum = a[i] * (i - minIndex);
                    }
                    
                } else if(a[i] > a[maxIndex]){
                    
                    if(a[minIndex] * (i - minIndex) > sum) {
                        maxIndex = i;
                        sum = a[minIndex] * (i - minIndex);
                    } else if(a[i] * (i - maxIndex) > sum){
                        minIndex = maxIndex;
                        i = maxIndex;
                        sum = a[i] * (i - maxIndex);
                    }
                    
                } else {
                    
                    if(maxIndex < minIndex){
                        minIndex = i;
                        sum = a[minIndex] * (i - maxIndex);
                    } else {
                        
                        if(a[i] * (i - minIndex) > sum){
                            maxIndex = i;
                            sum = a[i] * (i - minIndex);
                        }
                        
                    }
                    
                }
            }
            
            return a[minIndex]*( Math.abs(maxIndex - minIndex));
        }
        
	}
}

