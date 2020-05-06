package com.gf.dp.singleton;

/**
 * 意图通过缩小锁的粒度的方式提高效率，但是失败了
 */
public class Singleton_04 {
	
	private static Singleton_04 INSTANCE = null;
	
	private Singleton_04() {}

	public static Singleton_04 getInstance() {
		if (INSTANCE == null) {
			synchronized(Singleton_04.class) {
				INSTANCE = new Singleton_04();
			}
		}
		return INSTANCE;
	}

	public static void main(String[] args) {
		for (int i=0; i<100; i++) {
			new Thread(()->{
				System.out.println(Singleton_04.getInstance());
			}).start();
		}
	}

}
