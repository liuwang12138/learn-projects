package com.gf.dp.singleton;

/**
 * ����������ֻ���õ���ʱ��ż���
 * �̲߳���ȫ
 */
public class Singleton_02 {
	
	private static Singleton_02 INSTANCE = null;
	
	private Singleton_02() {}
	
	public static Singleton_02 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton_02();
		}
		
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		for (int i=0; i<100; i++) {
			new Thread(() -> {
				System.out.println(Singleton_02.getInstance());
			}).start();
		}
	}
	
	/**
	 * ִ�н����
	 *  com.gf.dp.singleton.Singleton_02@2cb59d9b
	 *	com.gf.dp.singleton.Singleton_02@b360a93
	 *	com.gf.dp.singleton.Singleton_02@b360a93
	 *	com.gf.dp.singleton.Singleton_02@b360a93
	 *	com.gf.dp.singleton.Singleton_02@b360a93
	 *	com.gf.dp.singleton.Singleton_02@b360a93
	 *	com.gf.dp.singleton.Singleton_02@b360a93
	 *	com.gf.dp.singleton.Singleton_02@b360a93
	 *	com.gf.dp.singleton.Singleton_02@b360a93
	 *	com.gf.dp.singleton.Singleton_02@b360a93
	 *	com.gf.dp.singleton.Singleton_02@b360a93
	 *	...
	 */

}
