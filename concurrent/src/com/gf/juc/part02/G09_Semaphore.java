package com.gf.juc.part02;

import java.util.concurrent.Semaphore;

/**
 * Semaphore 信号量
 * 	限流
 */
public class G09_Semaphore {
	
	Semaphore semaphore = new Semaphore(2);			// 允许n个线程同时acquire
	
	void m1() {
		try {
			semaphore.acquire();					// 阻塞方法
			System.out.println("m1 start...");
			Thread.sleep(2000);
			System.out.println("m1 over...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();					// 释放
		}
	}
	
	void m2() {
		try {
			semaphore.acquire();
			System.out.println("m2 start...");
			Thread.sleep(2000);
			System.out.println("m2 over...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
	
	public static void main(String[] args) {
		
		G09_Semaphore t = new G09_Semaphore();
		
		new Thread(t::m1).start();
		new Thread(t::m2).start();
	}

}
