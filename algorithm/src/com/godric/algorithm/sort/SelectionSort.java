package com.godric.algorithm.sort;

public class SelectionSort {
	
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i=0; i<arr.length-1; i++) {
			// 找出 i ~ arr.length-1 中的最小值，与arr[i]交换
			int minIndex = i;
			for (int j=i+1; j<arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				SortUtil.swap(arr, i, minIndex);
			}
		}
	}
	
	public static void main(String[] args) {
//		int arr[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
//		selectionSort(arr);
//		SortUtil.printArr(arr);
		
		int maxSize = 5000;
		int maxValue = 10000;
		int testTimes = 50000;

		while (testTimes-- > 0) {
			int arr[] = SortUtil.generateRandomArr(maxSize, maxValue);
			int arr1[] = SortUtil.copyArr(arr);
			int arr2[] = SortUtil.copyArr(arr);
			
			selectionSort(arr1);
			SortUtil.comparator(arr2);
			
			if (!SortUtil.isEquals(arr1, arr2)) {
				System.out.println("You have wrong in selection sort, arr :");
				SortUtil.printArr(arr);
				return;
			}
			if (testTimes % 100 == 0) {
				System.out.println("wait please, lost time is " + testTimes);
			}
		}
		
		System.out.println("nice！");
	}
	
}
