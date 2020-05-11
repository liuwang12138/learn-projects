package com.gf.juc.part02;

import java.util.concurrent.Exchanger;

/**
 * ���߳̽�������
 *
 */
public class G10_Exchanger {
	
	static Exchanger<String> exchanger = new Exchanger<>();
	
	static String s1 = "s1";
	static String s2 = "s2";
	
	public static void main(String[] args) {
		new Thread(() -> {
			try {
				s1 = exchanger.exchange(s1);				// ��������
				System.out.println(Thread.currentThread().getName() + "  " + s1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "t1").start();
		
		new Thread(() -> {
			try {
				s2 = exchanger.exchange(s2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "  " + s2);
		}, "t2").start();
	}
	

}
