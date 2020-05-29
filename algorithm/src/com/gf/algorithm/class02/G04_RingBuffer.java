package com.gf.algorithm.class02;

/**
 * 环形数组实现队列
 *
 */
public class G04_RingBuffer {
	
	private static final int LIMIT = 10;
	private static int[] arr = new int[LIMIT];
	private static int pushIndex = 0;
	private static int popIndex = 0;
	private static int size = 0;
	
	
	public static void push(int value) {
		if (size++ >= LIMIT) {
			throw new RuntimeException("队列已满....");
		}

		arr[pushIndex] = value;
		pushIndex = nextIndex(pushIndex);
	}
	
	
	public static int pop() {
		if (size-- <= 0) {
			throw new RuntimeException("队列已空....");
		}
		
		int result =  arr[popIndex];
		popIndex = nextIndex(popIndex);
		return result;
	}
	
	public static boolean isEmpty() {
		return size == 0;
	}
	
	
	private static int nextIndex(int index) {
		return (index + 1) % LIMIT;
	}
	
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		push(4);
		push(5);
		push(6);
		push(7);
		push(8);
		push(9);
		for (int i=0; i<3; i++) {
			System.out.println(pop());
		}
		
		System.out.println("======================================");
		push(10);
		push(11);
		push(12);
		push(13);
		while (!isEmpty()) {
			System.out.println(pop());
		}
		
		
	}
	
	
	

}
