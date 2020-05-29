package com.gf.algorithm.class03;

/**
 * ��������
 * 
 * 		Partition���̣�
 * 			����һ������arr����һ������num�����С�ڵ���num���������������ߣ�����num��������������ұ�
 * 			Ҫ�����ռ临�Ӷ�O(1)��ʱ�临�Ӷ�O(N)
 * 			(1) arr[i] <= num, ��ǰ����<=����һ��������<=������һ��λ�ã�i++
 * 			(2) arr[i] > num, i++
 * 		
 * 		Partition�������������������⣩
 * 			�������Ϊ���飺С�ڡ����ڡ�����
 * 			(1) arr[i] == num, i++
 * 			(2) arr[i] < num, arr[i]��<������һ������, <������, i++
 * 			(3) arr[i] > num, arr[i]��>������һ������, >������, i����ԭ��
 * 
 * 
 * 		����1.0
 * 			�����������������һ����������ֵ����Partition
 * 			[<=x, >x, x], Ȼ���ð�����x��>����һ��ֵ����
 * 				=>		[<=x, x, >x]
 * 			�������ݹ飬�Ҳ�����ݹ�
 * 
 * 			��������O(N^2)
 * 
 * 		����2.0
 * 			[<x, =x, >x]
 * 			Ȼ����С������ʹ����������ݹ�
 * 
 * 			��������O(N^2)
 * 
 * 		����3.0
 *			����2.0�Ļ����ϣ����ѡȡһ�����֣�Ȼ����arr[right]������������ȫ����ͬ
 *			
 *			O(N*logN)
 *
 */
public class G03_QuickSort {
	
	public static int partition(int[] arr, int k) {
		
		int lessArea = -1;

		for (int i=0; i<arr.length; i++) {
			
		}
		
		
		
		
		return -1;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	
	
	/**
	 * ��arr[left...right]������������Ļ��֣���arr[right]��Ϊ����ֵ
	 * @return һ������Ϊ2�����飬��ʾ �������� ����߽���ұ߽�
	 */
	public static int[] netherlandsFlag(int[] arr, int left, int right) {
		return new int[] {-1, -1};
	}
	
}
