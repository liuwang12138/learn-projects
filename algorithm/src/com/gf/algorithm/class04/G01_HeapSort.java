package com.gf.algorithm.class04;

/**
 *	堆：完全二叉树，可以由数组表示
 *		->	i位置的左孩子: 2*i+1
 *			i位置的右孩子：2*i+2
 *			i位置的父节点：(i-1) / 2
 *
 *	大根堆：每一棵子树的最大值都是自己头节点
 *	小根堆：每一棵子树的最小值都是自己头节点
 *
 *	1. 如何动态建一个大根堆?
 *		heapInsert(int[] arr, int index);			O(logN)
 *		最新插入的值在index处，不断上浮
 *		
 *		用N个值建大根堆的时间复杂度为	O(N*logN)
 *	2. 获取堆中的最大值，并在堆中删除这个最大值
 *		用最后一个值替换第一个值, heapSize--, heapify
 *		heapify(int[] arr, int index, int heapSize);			// 从index位置往下看，不断下沉，直到我的孩子都不再比我大，或者已经没有孩子了
 *		O(logN)
 *
 *	堆排序：
 *		1. 先让整个数组都变成大根堆结构，建立堆的过程：
 *			1.1 从上到下的方法，时间复杂度为O(N*logN)	->	用户一个一个给
 *			1.2 从下到上的方法，时间复杂度为O(N)			->	用户直接给一个数组，详见“建堆的优化”
 *		2. 把堆的最大值和堆末尾的值交换，然后减少堆的大小之后，再去调整堆，周而复始，时间复杂度为O(N*logN)
 *		3. 堆的大小减小成0之后，排序完成 
 *
 *	建堆的优化：从n-1到0，逐个heapify				->		O(N)
 *		N
 *
 *		 1				* logN
 *		...
 *		N/8				* 3
 *		N/4				* 2
 *		N/2				* 1
 *
 *		T(N) = N/2 * 1 + N/4 * 2 + N/8 * 3 + N/16 * 4 + ...
 *		2T(N) = N/2 *2 + N/2 * 2 + N/4 * 3 + N/8  * 4 + ...
 *
 * 	错位相减
 * 		T(N) = N/2 * 2 + N/2 + N/4 + N/8 + ...
 * 			 = N + (N/2 * (1-(1/2)  ^ n)) / (1 - 1/2) = 2N = O(N)
 * 
 *	堆排序的优势：额外空间复杂度为O(1)
 *	
 */
public class G01_HeapSort {
	
	private int[] arr;					// 数组，用于表示堆中的元素			i	父节点：(i-1)/2	左孩子 i*2+1	右孩子 i*2+2
	private int heapSize;

	public void push(int k) {
	}
	
	public static void main(String[] args) {
		
	}

}
