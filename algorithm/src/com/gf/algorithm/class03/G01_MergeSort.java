package com.gf.algorithm.class03;

import com.gf.algorithm.class01.SortUtil;

/**
 * 归并排序
 * 		1. 递归方式实现
 * 			左部分有序，右部分有序，merge
 * 			T(N) = 2*T(N/2) + O(N)	->	O(N*logN)
 * 		
 * 		2. 非递归
 * 			mergeSize = 1, 2, 4, 8, ...
 * 			O(N*logN)
 *
 */
public class G01_MergeSort {
	
	static int i = 0;
	
	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		
		process(arr, 0, arr.length-1);
	}
	//[0...5, 6..10]
	private static void process(int[] arr, int left, int right) {
		
		if (left == right) {		// base case
			return;
		}
		
		int mid = left + ((right - left) >> 1);			// left.....mid, mid+1....right
		
		process(arr, left, mid);
		process(arr, mid+1, right);
		merge(arr, left, mid, right);
	}
	
	private static void merge(int[] arr, int left, int mid, int right) {
		int[] help = new int[right - left + 1];

		int helpIndex = 0;
		int index1 = left;
		int index2 = mid + 1;

		while (index1 <=mid && index2 <=right) {
			if (arr[index1] <= arr[index2]) {
				// 左指针 <= 右指针，把左指针copy并右移
				help[helpIndex++] = arr[index1++];
			} else {
				help[helpIndex++] = arr[index2++];
			}
		}
		
		while (index1 <= mid) {
			help[helpIndex++] = arr[index1++];
		}

		while (index2 <= right) {
			help[helpIndex++] = arr[index2++];
		}

		int i=0;
		
		while (i<=(right - left)) {
			arr[left + i] = help[i];
			i++;
		}
	}
	
	public static void main(String[] args) {
		for (int i=0; i<50_000; i++) {
			int[] arr = SortUtil.generateRandomArr(1000, 50000);
			int[] arr1 = SortUtil.copyArr(arr);
			int[] arr2 = SortUtil.copyArr(arr);
			
			SortUtil.comparator(arr2);
			mergeSort(arr1);
			
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
