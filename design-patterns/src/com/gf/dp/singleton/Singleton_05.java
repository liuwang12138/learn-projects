package com.gf.dp.singleton;

/**
 * ����ģʽ double check lock
 */
public class Singleton_05 {
	
	/**
	 * �������Ҫ��volatile����ָֹ��������
	 * new Singleton_05() ����������:
	 * 		1. ���ٿռ䣬��Ա��������ʼֵ
	 * 		2. ��Ա������Ĭ��ֵ
	 * 		3. ջ����ָ��Ѷ���
	 * ����ָ��������Ĵ��ڣ�����2��3 �������ܳ���ָ����������������Ա����������ʼֵ��ʱ�򣬾ͻ����INSTANCE != null���жϣ�ֱ�ӷ���INSTANCE
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
