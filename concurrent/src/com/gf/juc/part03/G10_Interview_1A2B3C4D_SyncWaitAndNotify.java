package com.gf.juc.part03;

/**
 * synchronized  wait  notify
 */
public class G10_Interview_1A2B3C4D_SyncWaitAndNotify {
	
	static char[] as = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	static char[] bs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
	
	public static void main(String[] args) {
		
		Object mutex = new Object();
		
		
		new Thread(() -> {
			synchronized(mutex) {
				for (char a : as) {
					System.out.print(a);
					mutex.notify();
					try {
						mutex.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(() -> {
			synchronized(mutex) {
				for (char b : bs) {
					System.out.print(b);
					mutex.notify();
					try {
						mutex.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		
	}
}
