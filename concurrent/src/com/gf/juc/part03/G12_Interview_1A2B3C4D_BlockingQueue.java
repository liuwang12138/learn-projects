package com.gf.juc.part03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 用两个BlockingQueue实现
 */
public class G12_Interview_1A2B3C4D_BlockingQueue {
	
	static char[] as = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	static char[] bs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

	static BlockingQueue<Character> queueA = new LinkedBlockingQueue<>();
	static BlockingQueue<Character> queueB = new LinkedBlockingQueue<>();
	
	public static void main(String[] args) {
		
		new Thread(() -> {
			for (char a : as) {
				try {
					queueA.put(a);
					System.out.print(queueB.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(() -> {
			for (char b : bs) {
				try {
					System.out.print(queueA.take());
					queueB.put(b);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
