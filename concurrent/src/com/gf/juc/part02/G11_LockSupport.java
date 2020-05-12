package com.gf.juc.part02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport, 指定某个线程阻塞或开启
 */
public class G11_LockSupport {
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> {
			for (int i=0; i<10; i++) {
				System.out.println("t" + i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (i==5) {
					LockSupport.park();
				}
			}
		});
		
		
		t1.start();

		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("After 8 seconds...");
		
		LockSupport.unpark(t1);
		
	}

}
