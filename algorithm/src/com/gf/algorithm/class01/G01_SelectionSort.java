package com.gf.algorithm.class01;

/**
 * 	选择排序：
 * 		在0 ~ n-1范围选择最小的值，与0位置交换
 * 		在1 ~ n-1范围选择最小的值，与1位置交换
 * 		在2 ~ n-1范围选择最小的值，与2位置交换
 * 		...
 * 		在n ~ n-1范围选择最小的值，与n位置交换
 * 	O(n^2)
 */
public class G01_SelectionSort {
	
	public static void selectionSort(int[] arr) {
		
		int n = arr.length;
		
		for (int i=0; i<n-1; i++) {
			int minIndex= i;
			for (int j=i+1; j<n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			SortUtil.swap(arr, i, minIndex);
		}
	}
	
	public static void main(String[] args) {
		for (int i=0; i<50_000; i++) {
			int[] arr = SortUtil.generateRandomArr(1000, 50000);
			int[] arr1 = SortUtil.copyArr(arr);
			int[] arr2 = SortUtil.copyArr(arr);
			
			SortUtil.comparator(arr2);
			selectionSort(arr1);
			
			if (!SortUtil.isEquals(arr1, arr2)) {
				System.out.println("wrong! ");
				System.out.println("origin: ");
				SortUtil.printArr(arr);
				System.out.println("after: ");
				SortUtil.printArr(arr1);
				return;
			}
			
			System.out.println(i);
		}
		System.out.println("nice!");
	}
	
}
