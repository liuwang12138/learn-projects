package com.gf.dp.singleton;

/**
 * 单例模式 double check lock
 */
public class Singleton_05 {
	
	/**
	 * 这里必须要加volatile，防止指令重排序
	 * new Singleton_05() 的三个步骤:
	 * 		1. 开辟空间，成员变量赋初始值
	 * 		2. 成员变量赋默认值
	 * 		3. 栈变量指向堆对象
	 * 由于指令重排序的存在，导致2，3 两步可能出现指令重排序，这样当成员变量被赋初始值的时候，就会进入INSTANCE != null的判断，直接返回INSTANCE
	 */
	private static volatile Singleton_05 INSTANCE = null;
	
	private Singleton_05() {}
	
	public static Singleton_05 getInstance() {
		if (INSTANCE == null) {
			synchronized(Singleton_05.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton_05();
				}
			}
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		for (int i=0; i<100; i++) {
			new Thread(() -> {
				System.out.println(Singleton_05.getInstance());
			}).start();
		}
	}
	
}
