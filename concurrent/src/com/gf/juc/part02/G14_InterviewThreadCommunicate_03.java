package com.gf.juc.part02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * 	面试题：线程之间进行通信
 * 		实现一个容器，提供两个方法，add，size
 * 		写两个线程，线程 1 添加 10 个元素到容器中，线程 2 实现监控元素的个数，
 * 		当个数到 5 个时，线程 2 给出提示并结束
 * 
 * LockSupport
 *
 */
public class G14_InterviewThreadCommunicate_03 {
	
	List<Object> list = new ArrayList<>();
	static Thread t1;
	static Thread t2;
	
	void add(Object o) {
		list.add(o);
	}
	
	int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		G14_InterviewThreadCommunicate_03 t = new G14_InterviewThreadCommunicate_03();

		t1 = new Thread(() -> {
			for (int i=0; i<10; i++) {
				t.add(new Object());
				System.out.println("add" + i);
				if (t.size() == 5) {
					LockSupport.unpark(t2);
					LockSupport.park();
				}
			}
		});
		
		t2 = new Thread(() -> {
			if (t.size() != 5) {
				LockSupport.park();
			}
			
			System.out.println("t2 ...");
			LockSupport.unpark(t1);
		});
		
		t2.start();
		t1.start();
		
	}

}
