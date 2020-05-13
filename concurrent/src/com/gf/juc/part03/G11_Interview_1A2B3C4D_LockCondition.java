package com.gf.juc.part03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class G11_Interview_1A2B3C4D_LockCondition {

	static ReentrantLock lock = new ReentrantLock();
	
	static Condition c1 = lock.newCondition();
	static Condition c2 = lock.newCondition();
	
	static char[] as = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	static char[] bs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
	
	
	public static void main(String[] args) {
		new Thread(() -> {
			lock.lock();
			try {
				for (char a : as) {
					System.out.print(a);
					c2.signal();
					c1.await();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}).start();
		
		new Thread(() -> {
			lock.lock();
			try {
				for (char b : bs) {
					System.out.print(b);
					c1.signal();
					c2.await();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}).start();
	}

}
