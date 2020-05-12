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
			System.out.println("t2 ����");
		}).start();
		
	}

}
