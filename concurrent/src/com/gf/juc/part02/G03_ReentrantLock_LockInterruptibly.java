package com.gf.juc.part02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可以使用lockInterruptibly进行锁定，其他线程可以执行interrupt方法进行打断
 */
public class G03_ReentrantLock_LockInterruptibly {
	
	ReentrantLock lock = new ReentrantLock();
	
	void m1() {
		try {
			lock.lockInterruptibly();
			System.out.println("m1 start...");
			TimeUnit.SECONDS.sleep(5);
			System.out.println("m1 end...");
		} catch (InterruptedException e) {
			System.out.println("m1 被打断...");
		} finally {
			lock.unlock();
		}
	}
	
	void m2() {
		lock.lock();
		try {
			System.out.println("m2....");
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		G03_ReentrantLock_LockInterruptibly t = new G03_ReentrantLock_LockInterruptibly();
		Thread t1 = new Thread(t::m1);
		t1.start();
		new Thread(t::m2).start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
		
		
		
	}
	

}
