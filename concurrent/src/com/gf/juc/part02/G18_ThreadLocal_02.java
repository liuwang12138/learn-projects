package com.gf.juc.part02;

public class G18_ThreadLocal_02 {
	
	static ThreadLocal<Person> tl = new ThreadLocal<>();
	
	public static void main(String[] args) {
		new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(tl.get());
		}).start();
		
		
		new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tl.set(new Person());
		}).start();
		
	}
}
