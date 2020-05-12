package com.gf.juc.part02;

import java.util.concurrent.Semaphore;

/**
 * Semaphore �ź���
 * 	����
 */
public class G09_Semaphore {
	
	Semaphore semaphore = new Semaphore(2);			// ����n���߳�ͬʱacquire
	
	void m1() {
		try {
			semaphore.acquire();					// ��������
			System.out.println("m1 start...");
			Thread.sleep(2000);
			System.out.println("m1 over...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();					// �ͷ�
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
