package com.gf.algorithm.class01;

/**
 * ���ַ�02��
 * �ڸ��������������У��ҵ� >= ĳ����������λ��
 */
public class G05_BinarySearchNearLeft {

	/**
	 * @return ��������Ŀ��ֵ���±�
	 */
	public static int nearestIndexLeft(int[] arr, int num) {
		
		int left = 0;
		int right = arr.length - 1;
		
		int ans = -1;

		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if (arr[mid] >= num) {
				// ȥ���
				right = mid - 1;
				ans = mid;
			} else {
				// arr[mid] < num  ȥ�Ҳ�
				left = mid + 1;
			}
		}
		return ans;
	}
	
	public static int comparator(int[] arr, int num) {
		for (int i=0; i<arr.length; i++) {
			if (arr[i] >= num) {
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
			int b = nearestIndexLeft(arr, num);
			
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
