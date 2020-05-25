package com.gf.algorithm.class01;

/**
 *	 ��������
 *		0 ~ 0 ��Χ����
 *		0 ~ 1 ��Χ����
 *		...
 *		0 ~ n-1 ��Χ����
 *			n-1��ǰ���������n-2С��������
 *				ֱ������С�������û��������
 *
 *	O(n^2)
 *	���ݳ�ʼ״̬��Ӱ���㷨������
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
