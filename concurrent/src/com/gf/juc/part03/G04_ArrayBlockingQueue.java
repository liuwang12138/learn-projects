package com.gf.juc.part03;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class G04_ArrayBlockingQueue {
	public static void main(String[] args) {
		BlockingQueue<Object> queue = new ArrayBlockingQueue<>(5);
		
		for (int i=0; i<5; i++) {
			queue.add(new Object());
		}
		
		System.out.println("ready to add");
		boolean flag = queue.offer(new Object());
		System.out.println(flag);
		
		try {
			queue.put(new Object());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("over");

		
	}
}
