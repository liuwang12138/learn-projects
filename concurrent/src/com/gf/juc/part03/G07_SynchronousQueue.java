package com.gf.juc.part03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class G07_SynchronousQueue {
	
	public static void main(String[] args) {
		BlockingQueue<Object> queue = new SynchronousQueue<Object>();
		
		char[] cs = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
		
		new Thread(() -> {
			for (int i=0; i<10; i++) {
				try {
					System.out.println("ready to add...");
					queue.put(cs[i]);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("add over..." + i);
			}
		}).start();
		
		new Thread(() -> {
			Object o = null;
			do {
				try {
					o = queue.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(o);
			} while (o != null);
		}).start();
	}

}
