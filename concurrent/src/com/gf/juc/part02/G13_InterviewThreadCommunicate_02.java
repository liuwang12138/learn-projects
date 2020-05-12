package com.gf.juc.part02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 	面试题：线程之间进行通信
 * 		实现一个容器，提供两个方法，add，size
 * 		写两个线程，线程 1 添加 10 个元素到容器中，线程 2 实现监控元素的个数，
 * 		当个数到 5 个时，线程 2 给出提示并结束
 * 
 * wait 释放锁， notify 不释放锁
 * sleep 不释放锁
 *
 */
public class G13_InterviewThreadCommunicate_02 {
	
	List<Object> list = new ArrayList<>();
	
	void add(Object o) {
		list.add(o);
	}
	
	int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		G13_InterviewThreadCommunicate_02 t = new G13_InterviewThreadCommunicate_02();
		Object lock = new Object();
		
		new Thread(() -> {
			synchronized(lock) {
				for (int i=0; i<10; i++) {
					
					Object o = new Object();
					t.add(o);
					System.out.println("add " + i);
					
					if (t.size() == 5) {
						lock.notify();
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(() -> {
			synchronized(lock) {
				if (t.size() != 5) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("t2 结束");
				lock.notify();
			}
		}).start();
		
	}

}
