package com.gf.juc.part02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可以实现和synchronized同样的功能
 */
public class G01_ReentrantLock {
	
	ReentrantLock lock = new ReentrantLock();

	/*synchronized*/ void m1() {
		lock.lock();
		try {
			System.out.println("m1 start...");
			TimeUnit.SECONDS.sleep(5);
			System.out.println("m1 end...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	/*synchronized*/ void m2() {
		lock.lock();
		try {
			System.out.println("m2 start...");
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		G01_ReentrantLock t = new G01_ReentrantLock();
		new Thread(t::m1).start();
		new Thread(t::m2).start();
	}
}
