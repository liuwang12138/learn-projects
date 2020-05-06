package com.gf.dp.singleton;

/**
 * 第一种单例模式 -> 饿汉式
 * 不管有没有使用，直接new对象，会造成内存浪费
 */
public class Singleton_01 {
	
	private static final Singleton_01 INSTANCE = new Singleton_01();

	private Singleton_01() {}		// 单例模式的构造方法必须是private的
	
	public static Singleton_01 getInstance() {
		return INSTANCE;
	}

	
	public static void main(String[] args) {
		for (int i=0; i<100; i++) {
			new Thread(() -> {
				System.out.println(Singleton_01.getInstance());
			}).start();
		}
	}
}
