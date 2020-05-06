package com.gf.dp.singleton;

/**
 * 加锁，会影响效率
 */
public class Singleton_03 {
	
	private static Singleton_03 INSTANCE = null;
	
	private Singleton_03() {}
	
	public static synchronized Singleton_03 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton_03();
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		for (int i=0; i<100; i++) {
			new Thread(() -> {
				System.out.println(Singleton_03.getInstance());
			}).start();
		}
	}

}
