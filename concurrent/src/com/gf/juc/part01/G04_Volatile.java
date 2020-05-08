package com.gf.juc.part01;

import java.util.concurrent.TimeUnit;

/**
 * volatile  ��֤�̵߳Ŀɼ���
 *
 */
public class G04_Volatile {
	
	public static /*volatile*/ boolean flag = true;
	
	public void m() {
		System.out.println("m start...");
		
		while (flag) {
			/**
			 * ������ﲻ��ϵ����У���ôt2�̶߳�flag�ĸı䣬��t1�߳��ǲ��ɼ���
			 * �������˯��50ms����CPU����ʱ��ȥ��ѯ����ռ䣬�Ӷ��õ�flag�ĸı�
			 */
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("m end...");
	}

	public static void main(String[] args) throws InterruptedException {
		G04_Volatile g = new G04_Volatile();
		new Thread(()->{
			g.m();
		}).start();
		
		TimeUnit.SECONDS.sleep(5);
		new Thread(() -> flag = false).start();
	}
	
}
