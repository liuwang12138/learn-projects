package com.gf.juc.part01;

import java.util.List;
import java.util.ArrayList;

/**
 * volatile只能保证线程的可见性，不能保证原子性
 * synchronized既可以保证可见性，又能保证原子性
 */
public class G05_VolatileVsSynchronized {
	
	public static /*volatile*/ int count = 0;
	
	public static synchronized void addCount() {
		for (int i=0; i<1000; i++) {
			count++;
		}
	}
	
	public static void main(String[] args) {
		
		List<Thread> list = new ArrayList<>();
		
		for (int i=0; i<100; i++) {
			list.add(new Thread(() -> addCount()));
		}

		list.forEach(t -> t.start());
		
		list.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		System.out.println(count);
	}

}
