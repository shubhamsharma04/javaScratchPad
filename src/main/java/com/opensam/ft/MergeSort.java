package com.opensam.ft;

public class MergeSort {

	public static void main(String[] args) {
		int [] input = new int[]{4,1,3,9,7};
		
		mergeSort(input, 0, input.length);
	}

	private static void mergeSort(int[] arr, int l, int r) {
		 if (l < r)   
		   {
		        int m = (l+r)/2;
		        mergeSort(arr, l, m);
		        mergeSort(arr , m+1, r);
		        merge(arr, l, m, r);
		    }
	}

	private static void merge(int[] arr, int l, int m, int r) {

        int length = r - l + 1;
        int left = l;
        int right = m+1;
        int [] temp = new int[length];
        int k = 0;
        
        System.out.println(l+":"+m+":"+r);
        
        while(left <= m && right <= r){
            if(arr[left] < arr[right]){
                temp[k] = arr[left++];
            } else {
                temp[k] = arr[right++];
            }
            
            k++;
        }
        
        while(left <= m){
            temp[k++] = arr[left++];
        }
         while(right <= r){
            temp[k++] = arr[right++];
        }
        
        int index = 0;
        while(l <= r){
            arr[l++] = temp[index++];
        }
    }
	}

