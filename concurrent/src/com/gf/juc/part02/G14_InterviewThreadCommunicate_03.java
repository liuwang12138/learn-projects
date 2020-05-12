package com.gf.juc.part02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * 	�����⣺�߳�֮�����ͨ��
 * 		ʵ��һ���������ṩ����������add��size
 * 		д�����̣߳��߳� 1 ��� 10 ��Ԫ�ص������У��߳� 2 ʵ�ּ��Ԫ�صĸ�����
 * 		�������� 5 ��ʱ���߳� 2 ������ʾ������
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
