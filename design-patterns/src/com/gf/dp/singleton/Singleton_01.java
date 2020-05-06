package com.gf.dp.singleton;

/**
 * ��һ�ֵ���ģʽ -> ����ʽ
 * ������û��ʹ�ã�ֱ��new���󣬻�����ڴ��˷�
 */
public class Singleton_01 {
	
	private static final Singleton_01 INSTANCE = new Singleton_01();

	private Singleton_01() {}		// ����ģʽ�Ĺ��췽��������private��
	
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
