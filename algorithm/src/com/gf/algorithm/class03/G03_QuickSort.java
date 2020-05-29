package com.gf.algorithm.class03;

/**
 * 快速排序：
 * 
 * 		Partition过程：
 * 			给定一个数组arr，和一个整数num。请把小于等于num的数放在数组的左边，大于num的数放在数组的右边
 * 			要求额外空间复杂度O(1)，时间复杂度O(N)
 * 			(1) arr[i] <= num, 当前数和<=区下一个交换，<=区右扩一个位置，i++
 * 			(2) arr[i] > num, i++
 * 		
 * 		Partition升级：（荷兰国旗问题）
 * 			把数组分为三块：小于、等于、大于
 * 			(1) arr[i] == num, i++
 * 			(2) arr[i] < num, arr[i]与<区域右一个交换, <区右扩, i++
 * 			(3) arr[i] > num, arr[i]与>区域右一个交换, >区左扩, i留在原地
 * 
 * 
 * 		快排1.0
 * 			在整个数组上拿最后一个数做划分值，做Partition
 * 			[<=x, >x, x], 然后拿把最后的x与>区第一个值交换
 * 				=>		[<=x, x, >x]
 * 			左侧继续递归，右侧继续递归
 * 
 * 			最差情况：O(N^2)
 * 
 * 		快排2.0
 * 			[<x, =x, >x]
 * 			然后在小于区域和大于区域做递归
 * 
 * 			最差情况：O(N^2)
 * 
 * 		快排3.0
 *			快排2.0的基础上，随机选取一个数字，然后与arr[right]做交换，其他全部相同
 *			
 *			O(N*logN)
 *
 */
public class G03_QuickSort {
	
	public static void partition(int[] arr) {
		
	}
	
	/**
	 * 在arr[left...right]上做荷兰国旗的划分，以arr[right]作为划分值
	 * @return 一个长度为2的数组，表示 等于区域 的左边界和右边界
	 */
	public static int[] netherlandsFlag(int[] arr, int left, int right) {
		return new int[] {-1, -1};
	}
	
}
