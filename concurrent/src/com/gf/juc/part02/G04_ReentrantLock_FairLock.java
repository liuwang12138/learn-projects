package com.gf.juc.part02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可以指定为公平锁
 * 等待队列中先来的先执行
 */
public class G04_ReentrantLock_FairLock {
	
	Lock lock = new ReentrantLock(true);
	
	void m1() {
		for (int i=0; i<100; i++) {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "...");
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		G04_ReentrantLock_FairLock t = new G04_ReentrantLock_FairLock();
		new Thread(t::m1, "t1").start();
		new Thread(t::m1, "t2").start();
	}
	
}
