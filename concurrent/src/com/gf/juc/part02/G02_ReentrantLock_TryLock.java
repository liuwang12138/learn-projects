package com.gf.juc.part02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock中有tryLock，可以尝试锁定
 */
public class G02_ReentrantLock_TryLock {
	
	ReentrantLock lock = new ReentrantLock();

	void m1() {
		lock.lock();
		try {
			System.out.println("m1 start...");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("m1 end...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	void m2() {
		try {
			boolean locked = lock.tryLock(3, TimeUnit.SECONDS);
			
			System.out.println("locked : " + locked);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		G02_ReentrantLock_TryLock t = new G02_ReentrantLock_TryLock();
		new Thread(t::m1).start();
		new Thread(t::m2).start();
	}
}
