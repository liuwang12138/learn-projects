package com.gf.algorithm.class01;

/**
 * 1. 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数？
 * 2. 一个数组中有两种数都出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数？
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
		
		int rightOne = eor & (~eor + 1);			// 最右侧的1

		int a = 0;

		for (int i=0; i<arr.length; i++) {
			if ((arr[i] & rightOne) == 0) {
				// 第 n 位等于 0 的那部分
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
