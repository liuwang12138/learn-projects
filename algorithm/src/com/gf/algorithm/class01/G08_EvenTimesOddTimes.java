package com.gf.algorithm.class01;

/**
 * 1. һ����������һ���������������Σ���������������ż���Σ���ô�ҵ�����ӡ��������
 * 2. һ�����������������������������Σ���������������ż���Σ���ô�ҵ�����ӡ����������
 */
public class G08_EvenTimesOddTimes {
	
	public static int oneOddOtherEven(int[] arr) {
		return -1;
	}
	
	public static int[] twoOddOtherEven(int[] arr) {
		return new int[] {-1, -1};
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5, 6, 1, 1, 1, 3, 2, 5, 5, 4, 6};			// 5
		int[] arr2 = {1, 2, 3, 4, 5, 6, 1, 1, 1, 3, 2, 5, 5, 4, 6, 4};		// 4, 5
		
		System.out.println(oneOddOtherEven(arr1));
		
		int[] result2 = twoOddOtherEven(arr2);
		System.out.println(result2[0] + ", " + result2[1]);
	}
	
}