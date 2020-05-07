package com.gf.juc.part01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �����̵߳����ַ�ʽ��
 * 		1. extends Thread
 * 		2. implements Runnable 
 * 
 * ������е����֣��Ǿ���ͨ���̳߳������������̳߳ر�����Ҳ��ͨ���������ַ�ʽ�������߳�
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
