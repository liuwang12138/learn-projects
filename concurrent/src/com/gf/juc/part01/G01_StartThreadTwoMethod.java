package com.gf.juc.part01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 启动线程的两种方式：
 * 		1. extends Thread
 * 		2. implements Runnable 
 * 
 * 如果还有第三种，那就是通过线程池启动，但是线程池本质上也是通过以上两种方式启动的线程
 */
public class G01_StartThreadTwoMethod {
	
	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		t1.start();
		
		Thread t2 = new Thread(new MyThread2());
		t2.start();
		
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
		fixedThreadPool.execute(() -> {
			for (int i=0; i<10; i++) {
				System.out.println("thread pool..." + i);
			}
		});
		
		for (int i=0; i<10; i++) {
			System.out.println("main..." + i);
		}
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println("thread1..." + i);
		}
	}
	
}

class MyThread2 implements Runnable {
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println("thread2..." + i);
		}
	}
}
