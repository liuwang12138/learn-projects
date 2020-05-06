package com.godric.algorithm.sort;

public class BubbleSort {
	
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 0 ~ n-2
		// 0 ~ n-3
		for (int i=arr.length-2; i>=0; i--) {
			for (int j=0; j<=i; j++) {
				if (arr[j] > arr[j+1]) {
					SortUtil.swap(arr, j, j+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int testTimes = 10000;
		int maxSize = 5000;
		int maxValue = 10000;
		
		while (testTimes-- > 0) {
			int[] arr = SortUtil.generateRandomArr(maxSize, maxValue);
			int[] arr1 = SortUtil.copyArr(arr);
			int[] arr2 = SortUtil.copyArr(arr);
			
			bubbleSort(arr1);
			SortUtil.comparator(arr2);
			
			if (!SortUtil.isEquals(arr1, arr2)) {
				System.out.println("You have wrong in bubble sort, arr :");
				System.out.print("arr = ");
				SortUtil.printArr(arr);
				
				System.out.print("arr1 = ");
				SortUtil.printArr(arr1);

				System.out.print("arr2 = ");
				SortUtil.printArr(arr2);

				return;
			}
			if (testTimes % 100 == 0) {
				System.out.println("wait please, lost time is " + testTimes);
			}
		}
		System.out.println("nice£¡");
	}
	
	
	

}
