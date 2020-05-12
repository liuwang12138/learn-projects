package com.gf.juc.part02;

public class G17_ThreadLocal_01 {
	static Person p = new Person();
	
	public static void main(String[] args) {
		new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(p.name);
		}).start();
		
		
		new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			p.name = "lisi";
		}).start();
		
	}
}

class Person {
	String name = "zhangsan";
}