package com.gf.algorithm.class01;

/**
 * 二分法03：
 * 在一个有序数组中，找<=某个数最右侧的位置
 */
public class G06_BinarySearchNearRight {
	
	public static int nearestIndexRight(int[] arr, int num) {
		
		int left = 0;
		int right = arr.length - 1;
		
		int ans = -1;
		
		while (left <= right) {
			int mid = left + ((right - left) >> 1);

			if (arr[mid] <= num) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return ans;
	}
	
	public static int comparator(int[] arr, int num) {
		for (int i=arr.length-1; i>=0; i--) {
			if (arr[i] <= num) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		for (int i=0; i<50_000; i++) {
			int[] arr = SortUtil.generateRandomArr(1000, 50000);
			SortUtil.comparator(arr);
			
			
			int num = (int)(Math.random() * 50000) + 1;

			int a = comparator(arr, num);
			int b = nearestIndexRight(arr, num);
			
			if (a != b) {
				System.out.println("wrong! ");
				System.out.println("arr: ");
				SortUtil.printArr(arr);
				System.out.print("num: ");
				System.out.println(num);
				System.out.println("a = " + a);
				System.out.println("b = " + b);
				return;
			}
			
			System.out.println(i);
		}
		System.out.println("nice!");
	}
	

}
