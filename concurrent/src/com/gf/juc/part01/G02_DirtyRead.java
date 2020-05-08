package com.gf.juc.part01;

import java.util.concurrent.TimeUnit;

/**
 * ��ҵ��д����������������������������������������
 * �����ԭ������ͬ�������ͷ�ͬ����������ͬʱִ��
 */
public class G02_DirtyRead {
	
	static Account account;
	
	public static synchronized void setCount() {
		account = new Account();
		account.name = "zhangsan";
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			
		}
		account.count = 100;
	}
	
	public static int getCount() {
		return account.count;
	}
	
	public static void main(String[] args) {
		new Thread(()->setCount()).start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			
		}
		new Thread(() -> {
			System.out.println(getCount());
		}).start();
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			
		}
		new Thread(() -> {
			System.out.println(getCount());
		}).start();
	}
}

class Account {
	String name;
	int count;
}
