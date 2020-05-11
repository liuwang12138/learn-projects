package com.gf.juc.part02;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch ÃÅãÅ
 * 
 * ÀàËÆÓÚjoin()
 */
public class G05_CountDownLatch {
	
	static Thread[] threads = new Thread[1000];
	
	static CountDownLatch countDownLatch = new CountDownLatch(threads.length);
	
	
	void m() {
		System.out.println(Thread.currentThread().getName() + " -> m()...");
		try {
			Thread.sleep(2000);
			
			countDownLatch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		G05_CountDownLatch t = new G05_CountDownLatch();

		for (int i=0; i<threads.length; i++ ) {
			threads[i] = new Thread(t::m);
		}

		for (Thread thread : threads) { 
			thread.start();
		}
		
		System.out.println("aaa....");
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("bbb....");
		
	}
	
}
