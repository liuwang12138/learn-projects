package com.gf.juc.part02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 	�����⣺����������������
 * 		дһ���̶�������ͬ��������ӵ�� put �� get �������Լ� getCount ������
 * 		�ܹ�֧�� 2 ���������߳��Լ� 10 ���������̵߳���������
 * 
 * condition
 */
public class G16_InterviewProducerConsumer_02 {

	List<Object> list = new ArrayList<>();
	final static int MAX_SIZE = 10;
	
	Lock lock = new ReentrantLock();

	Condition consumer = lock.newCondition();
	Condition producer = lock.newCondition();
	
	void put(Object o) {
		lock.lock();
		try {
			while (getCount() >= MAX_SIZE) {
				try {
					producer.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.add(o);
			System.out.println(Thread.currentThread().getName() + " put, now size is " + getCount());
			
			consumer.signalAll();
		} finally {
			lock.unlock();
		}
	}

	Object get() {
		lock.lock();
		Object o = null;
		try {
			while (getCount() <= 0) {
				try {
					consumer.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			o = list.get(getCount() - 1);
			list.remove(getCount() - 1);
			producer.signalAll();
			System.out.println(Thread.currentThread().getName() + " get, now size is " + getCount());
		} finally {
			lock.unlock();
		}
		 return o;
		 
	}
	
	int getCount() {
		return list.size();
	}
	
	public static void main(String[] args) {
		G16_InterviewProducerConsumer_02 t = new G16_InterviewProducerConsumer_02();
		
		for (int i=0; i<2; i++) {
			// producer
			new Thread(() -> {
				while (true) {
					t.put(new Object());
				}
			}, "producer" + i).start();
		}
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i=0; i<10; i++) {
			// consumer
			new Thread(() -> {
				while (true) {
					t.get();
				}
			}, "consumer" + i).start();
		}
	}
}
