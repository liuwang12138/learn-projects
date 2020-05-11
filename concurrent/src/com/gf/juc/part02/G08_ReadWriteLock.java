package com.gf.juc.part02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * ¶ÁÐ´Ëø
 *		¶ÁËø¹²Ïí£¬Ð´ËøÅÅËû
 *
 */
public class G08_ReadWriteLock {
	
	void read(Lock lock) {
		lock.lock();
		try {
			Thread.sleep(1000);
			System.out.println("read over");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	void write(Lock lock) {
		lock.lock();
		try {
			Thread.sleep(1000);
			System.out.println("write over");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		G08_ReadWriteLock t = new G08_ReadWriteLock();
		
//		Lock lock = new ReentrantLock();
		
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		
		ReadLock readLock = lock.readLock();
		WriteLock writeLock = lock.writeLock();
		
		for (int i=0; i<18; i++) {
			new Thread(() -> t.read(readLock)).start();
		}
		for (int i=0; i<2; i++) {
			new Thread(() -> t.write(writeLock)).start();
		}
	}

}
