package com.gf.algorithm.class01;

/**
 * 二分法01：
 * 	在给定的有序数组中，找某个数是否存在
 */
public class G04_BinarySearchExist {

	public static boolean binarySearchExist(int[] arr, int num) {
		
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			
			if (arr[mid] == num) {
				return true;
			} else if (arr[mid] > num) {
				right = mid - 1;
			} else {
				// arr[mid] < num
				left = mid + 1;
			}
		}
		
		return false;
	}
	
	public static boolean comparator(int[] arr, int num) {
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		for (int i=0; i<50_000; i++) {
			int[] arr = SortUtil.generateRandomArr(1000, 50000);
			SortUtil.comparator(arr);
			
			
			int num = (int)(Math.random() * 50000) + 1;
			
			boolean flagA = comparator(arr, num);
			
			boolean flagB = binarySearchExist(arr, num);
			
			if (flagA != flagB) {
				System.out.println("wrong! ");
				System.out.println("arr: ");
				SortUtil.printArr(arr);
				System.out.print("num: ");
				System.out.println(num);
				System.out.println("flagA = " + flagA);
				System.out.println("flagB = " + flagB);
				return;
			}
		}
		System.out.println("nice!");
		
	}
}
