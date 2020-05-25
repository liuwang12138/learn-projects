package com.gf.juc.part03;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class G13_Interview_1A2B3C4D_TransferQueue {
	
	static char[] as = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	static char[] bs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
	
	static TransferQueue<Character> queue = new LinkedTransferQueue<>();
	
	public static void main(String[] args) {
		
		new Thread(() -> {
			for (char a : as) {
				try {
					queue.transfer(a);
					System.out.print(queue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(() -> {
			for (char b : bs) {
				try {
					System.out.print(queue.take());
					queue.transfer(b);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		/**
		 *  ThreadPoolExecutor的七个参数：
		 *  	coreSize
		 *  	maxSize
		 *  	aliveTime
		 *  	timeUnit
		 *  	queue
		 *  	factory
		 *  	handler
		 */
		
	}

}
