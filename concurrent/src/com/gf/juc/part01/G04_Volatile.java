package com.gf.juc.part01;

import java.util.concurrent.TimeUnit;

/**
 * volatile  保证线程的可见性
 *
 */
public class G04_Volatile {
	
	public static /*volatile*/ boolean flag = true;
	
	public void m() {
		System.out.println("m start...");
		
		while (flag) {
			/**
			 * 如果这里不间断的运行，那么t2线程对flag的改变，对t1线程是不可见的
			 * 如果这里睡眠50ms，那CPU就有时间去查询共享空间，从而得到flag的改变
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
