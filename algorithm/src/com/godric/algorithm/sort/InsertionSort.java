package com.godric.algorithm.sort;

public class InsertionSort {
	
	public static void insertionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 0 ~ i		i ²åµ½  0 ~ i-1ÖÐÈ¥
		for (int i=1; i<arr.length; i++) {
			for (int j=i-1; j>=0&&arr[j]>arr[j+1]; j--) {
				SortUtil.swap(arr, j, j+1);
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
			
			insertionSort(arr1);
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
