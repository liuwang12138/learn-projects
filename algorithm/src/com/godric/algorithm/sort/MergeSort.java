package com.godric.algorithm.sort;

public class MergeSort {
	
	public static void mergeSort(int[] arr, int left, int right) {
		// 归并排序0 ~ mid-1, mid ~ arr.length-1
		if (left >= right) {
			return;
		}
		
		int mid = left + (right - left) >> 1;
		mergeSort(arr, left, mid-1);
		mergeSort(arr, mid, right);
		
		merge(arr, left, mid, right);
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		// 把arr[left.....mid-1] 和arr[mid....right]合并
		
		for (int i=mid; i<=right; i++) {
			// 每次把arr[i] 放到arr[left....i-1中]
			if (arr[i] >= arr[i-1]) {
				return;
			}
			int k = i;
			while (k > left && arr[k] < arr[k-1]) {
				SortUtil.swap(arr, k, k-1);
				k--;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int maxSize = 5000;
		int maxValue = 10000;
		int testTimes = 50000;

		while (testTimes-- > 0) {
			int arr[] = SortUtil.generateRandomArr(maxSize, maxValue);
			int arr1[] = SortUtil.copyArr(arr);
			int arr2[] = SortUtil.copyArr(arr);
			
			mergeSort(arr1, 0, arr1.length-1);
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
