package com.gf.juc.part01;

import java.util.concurrent.TimeUnit;

/**
 * �׳��쳣��ʱ�򣬻��Զ��ͷ���
 */
public class G03_ExceptionExitSync {
	
	public static synchronized void print() {
		int i = 0 ;
		while (true) {
			System.out.println(Thread.currentThread().getName() + " printing...");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
			if (i % 5 == 0) {
				int k = 1 / 0;			// ������׳��쳣���Զ��ͷ���
			}
		}
	}
	
	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			new Thread(() -> {
				print();
			}).start();
		}
	}
	
}
