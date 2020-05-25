package com.gf.algorithm.class01;

/**
 *	 插入排序
 *		0 ~ 0 范围有序
 *		0 ~ 1 范围有序
 *		...
 *		0 ~ n-1 范围有序：
 *			n-1往前看，如果比n-2小，则往左换
 *				直到不再小，或左边没有数字了
 *
 *	O(n^2)
 *	数据初始状态会影响算法的性能
 */
public class G03_InsertionSort {

	public static void insertionSort(int[] arr) {
		int n = arr.length;
		
		// 0 ~ i
		for (int i=1; i<n; i++) {
			for (int j=i; j>0 && arr[j] < arr[j-1]; j--) {
				SortUtil.swap(arr, j, j-1);
			}
		}
	}
	
	public static void main(String[] args) {
		for (int i=0; i<50_000; i++) {
			int[] arr = SortUtil.generateRandomArr(1000, 50000);
			int[] arr1 = SortUtil.copyArr(arr);
			int[] arr2 = SortUtil.copyArr(arr);
			
			SortUtil.comparator(arr2);
			insertionSort(arr1);
			
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
