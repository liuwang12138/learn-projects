package com.gf.juc.part02;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CylicBarrier - Õ¤À¸
 */
public class G06_CyclicBarrier {
	
	static Random r = new Random();
	
	public static void main(String[] args) {
		
		CyclicBarrier cb = new CyclicBarrier(20, () -> {
			System.out.println("ÈËÂú£¬·ÅÐÐ");
		});
		
		for (int i=0; i<100; i++) {
			new Thread(()->{
				try {
					Thread.sleep(r.nextInt(5000));
					cb.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
			
		}
	}
	
}
