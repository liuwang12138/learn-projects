package com.gf.juc.part02;

import java.util.ArrayList;
import java.util.List;

/**
 * 	�����⣺����������������
 * 		дһ���̶�������ͬ��������ӵ�� put �� get �������Լ� getCount ������
 * 		�ܹ�֧�� 2 ���������߳��Լ� 10 ���������̵߳���������
 */
public class G15_InterviewProducerConsumer_01 {

	List<Object> list = new ArrayList<>();

	final static int MAX_SIZE = 10;
	
	synchronized void put(Object o) {
		while (getCount() >= MAX_SIZE) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		list.add(o);
		System.out.println(Thread.currentThread().getName() + " put, now size is " + getCount());
		
		this.notifyAll();
	}

	synchronized Object get() {
		while (getCount() <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		 Object o = list.get(getCount() - 1);
		 list.remove(getCount() - 1);
		 this.notifyAll();
		 System.out.println(Thread.currentThread().getName() + " get, now size is " + getCount());
		 return o;
	}
	
	int getCount() {
		return list.size();
	}
	
	public static void main(String[] args) {
		G15_InterviewProducerConsumer_01 t = new G15_InterviewProducerConsumer_01();
		
		for (int i=0; i<10; i++) {
			// consumer
			new Thread(() -> {
				while (true) {
					t.get();
				}
			}, "consumer" + i).start();
		}
		
		for (int i=0; i<2; i++) {
			// producer
			new Thread(() -> {
				while (true) {
					t.put(new Object());
				}
			}, "producer" + i).start();
		}
		
	}
}
