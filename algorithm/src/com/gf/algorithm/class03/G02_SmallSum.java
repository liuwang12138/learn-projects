package com.gf.algorithm.class03;

import com.gf.algorithm.class01.SortUtil;

/**
 * С������
 * 	��һ�������У�һ������߱���С�������ܺͣ�������С�ͣ���������С���ۼ�������������С�͡�
 * 	������С�͡�
 *		���ù鲢�����merge���̣�ÿ��merge��ʱ������С��
 *		����������������ʱ���������飬������С�ͣ�
 *		�������ִ�����������ʱ��ֱ�ӿ������飬������С��
 *		����С�������ʱ�򣬲���m��С�� - m�������±��������
 *
 * �������⣺���������
 * 	ֻҪ����n������ж������ִ���/С��n
 * 		   n���ұ��ж������ִ���/С��n
 * 	�Ϳ�����鲢����
 */
public class G02_SmallSum {
	
	public static int getSmallSum(int[] arr) {
		
		if (arr == null || arr.length < 2) {
			return 0;
		}
		
		
		return process(arr, 0, arr.length -1 );
	}

	private static int process(int[] arr, int left, int right) {
		if (left == right) return 0;

		int mid = left + ((right - left) >> 1);
		
		return process(arr, left, mid)
				+
			   process(arr, mid + 1, right)
			    +
			   merge(arr, left, mid, right);
	}
	
	
	private static int merge(int[] arr, int left, int mid, int right) {
		int[] help = new int[right - left + 1];
		
		int leftIndex = left;
		int rightIndex = mid+1;
		int helpIndex = 0;

		int result = 0;
		
		while (leftIndex<=mid && rightIndex<=right) {
			
			if (arr[leftIndex] < arr[rightIndex]) {
				// ����С�ͣ���ָ���ƶ�
				help[helpIndex++] = arr[leftIndex];
				result += arr[leftIndex++] * (right - rightIndex + 1);
			} else {
				// arr[leftIndex] >= arr[rightIndex]
				// ������С�ͣ���ָ���ƶ�
				help[helpIndex++] = arr[rightIndex++];
			}
			
//			result += arr[leftIndex] < arr[rightIndex] ? (right - rightIndex + 1) * arr[leftIndex] : 0;
//			help[helpIndex++] = arr[leftIndex] < arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
			
		}
		
		while (leftIndex <= mid) {
			help[helpIndex++] = arr[leftIndex++];
		}
		while (rightIndex <= right) {
			help[helpIndex++] = arr[rightIndex++];
		}
		
		for (int i=0; i<help.length; i++) {
			arr[left + i] = help[i];
		}
		
		return result;
	}
	
	public static int comparator(int[] arr) {
		int result = 0;
		for (int i=0; i<arr.length; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if (arr[i] < arr[j]) {
					result += arr[i];
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		for (int i=0; i<5_0000; i++) {
			int[] arr = SortUtil.generateRandomArr(1000, 50000);
			int[] arr1 = SortUtil.copyArr(arr);
			int[] arr2 = SortUtil.copyArr(arr);
			
			int result1 = comparator(arr1);
			int result2 = getSmallSum(arr2);
			
			if (result1 != result2) {
				System.out.println("wrong! ");
				System.out.println("origin: ");
				SortUtil.printArr(arr);
				
				System.out.println("result1 = " + result1);
				System.out.println("result2 = " + result2);
				return;
			}
			
			System.out.println(i);
		}
		
		System.out.println("nice!");
	}
	
}
