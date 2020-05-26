package com.gf.algorithm.class01;

/**
 * 1. һ����������һ���������������Σ���������������ż���Σ���ô�ҵ�����ӡ��������
 * 2. һ�����������������������������Σ���������������ż���Σ���ô�ҵ�����ӡ����������
 */
public class G08_EvenTimesOddTimes {
	
	public static int oneOddOtherEven(int[] arr) {
		int eor = 0;
		
		for (int i=0; i<arr.length; i++) {
			eor ^= arr[i];
		}

		return eor;
	}
	
	public static int[] twoOddOtherEven(int[] arr) {
		int eor = 0;
		for (int i=0; i<arr.length; i++) {
			eor ^= arr[i];
		}
		
		int rightOne = eor & (~eor + 1);			// ���Ҳ��1

		int a = 0;

		for (int i=0; i<arr.length; i++) {
			if ((arr[i] & rightOne) == 0) {
				// �� n λ���� 0 ���ǲ���
				a ^= arr[i];
			}
		}
		
		int b = eor ^ a;
		
		return new int[] {a, b};
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5, 6, 1, 1, 1, 3, 2, 5, 5, 4, 6};			// 5
		int[] arr2 = {1, 2, 3, 4, 5, 6, 1, 1, 1, 3, 2, 5, 5, 4, 6, 4};		// 4, 5
		
		System.out.println(oneOddOtherEven(arr1));
		
		int[] result2 = twoOddOtherEven(arr2);
		System.out.println(result2[0] + ", " + result2[1]);
	}
	
}
