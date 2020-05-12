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
 */
public class G12_InterviewThreadCommunicate_01 {
	
	volatile List<Object> list = new ArrayList<>();
	
	void add(Object o) {
		list.add(o);
	}
	
	int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		G12_InterviewThreadCommunicate_01 t = new G12_InterviewThreadCommunicate_01();
		
		new Thread(() -> {
			for (int i=0; i<10; i++) {
				Object o = new Object();
				t.add(o);
				System.out.println("add " + i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		
		
		new Thread(() -> {
			while (true) {
				if (t.size() == 5) {
					break;
				}
			}
			System.out.println("t2 结束");
		}).start();
		
	}

}
