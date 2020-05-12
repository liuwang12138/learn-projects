package com.gf.juc.part02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 	�����⣺�߳�֮�����ͨ��
 * 		ʵ��һ���������ṩ����������add��size
 * 		д�����̣߳��߳� 1 ��� 10 ��Ԫ�ص������У��߳� 2 ʵ�ּ��Ԫ�صĸ�����
 * 		�������� 5 ��ʱ���߳� 2 ������ʾ������
 * 
 * wait �ͷ����� notify ���ͷ���
 * sleep ���ͷ���
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
				System.out.println("t2 ����");
				lock.notify();
			}
		}).start();
		
	}

}
