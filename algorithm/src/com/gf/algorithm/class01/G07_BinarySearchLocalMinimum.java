package com.gf.algorithm.class01;

/**
 * 二分法03：
 * 		局部最小值问题
 */
public class G07_BinarySearchLocalMinimum {
	
	public static int localMinimum(int[] arr) {
		
		if (arr == null || arr.length == 0) {
			return -1;			// not exist
		}
		
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		
		int left = 1;
		int right = arr.length - 2;
		
		int mid = 0;
		
		while (left <= right) {
			mid = left + ((right - left) >> 1);
			
			if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			} else if (arr[mid] > arr[mid + 1]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		
		return mid;
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10};
		System.out.println(localMinimum(arr));
	}
	
}
