package com.gf.algorithm.class01;

/**
 * 	冒泡排序：
 *		0 ~ n-1:
 *			0, 1比较，交换
 *			1, 2比较，交换
 *			...
 *			n-1, n-2比较，交换
 *
 * 		0 ~ n-2:
 * 		0 ~ n-3:
 * 
 * 	O(n^2)
 */
public class G02_BubbleSort {
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		
		// 0 ~ i
		for (int i=n-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if (arr[j] > arr[i]) {
					SortUtil.swap(arr, i, j);
				}
			}
		}
		
	}

	public static void main(String[] args) {
		for (int i=0; i<50_000; i++) {
			int[] arr = SortUtil.generateRandomArr(1000, 50000);
			int[] arr1 = SortUtil.copyArr(arr);
			int[] arr2 = SortUtil.copyArr(arr);
			
			SortUtil.comparator(arr2);
			bubbleSort(arr1);
			
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
