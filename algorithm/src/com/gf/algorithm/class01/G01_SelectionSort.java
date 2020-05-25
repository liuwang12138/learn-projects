package com.gf.algorithm.class01;

/**
 * 	ѡ������
 * 		��0 ~ n-1��Χѡ����С��ֵ����0λ�ý���
 * 		��1 ~ n-1��Χѡ����С��ֵ����1λ�ý���
 * 		��2 ~ n-1��Χѡ����С��ֵ����2λ�ý���
 * 		...
 * 		��n ~ n-1��Χѡ����С��ֵ����nλ�ý���
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
