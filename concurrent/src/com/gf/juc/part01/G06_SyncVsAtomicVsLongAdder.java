package com.gf.juc.part01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class G06_SyncVsAtomicVsLongAdder {
	
	public static int count = 0;
	
	public static AtomicInteger atomicCount = new AtomicInteger();
	
	public static LongAdder laCount = new LongAdder();
	
	public static synchronized void syncAdd() {
		for (int i=0; i<10000; i++)
			count++;
	}
	
	public static void atomicAdd() {
		for (int i=0; i<10000; i++) {
			atomicCount.incrementAndGet();
		}
	}
	
	public static void longAdderAdd() {
		for (int i=0; i<10000; i++) {
			laCount.add(1L);
		}
	}
	
	public static void main(String[] args) {
		
		List<Thread> syncThreads = new ArrayList<>();
		List<Thread> atomicThreads = new ArrayList<>();
		List<Thread> longAdderThreads = new ArrayList<>();
		for (int i=0; i<100000; i++) {
			syncThreads.add(new Thread(()->syncAdd()));
		}
		for (int i=0; i<100000; i++) {
			atomicThreads.add(new Thread(()->atomicAdd()));
		}
		for (int i=0; i<100000; i++) {
			longAdderThreads.add(new Thread(()->longAdderAdd())); 
		}
		
		Long t1 = System.currentTimeMillis();
		
		syncThreads.forEach(t->t.start());
		syncThreads.forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Long t2 = System.currentTimeMillis();
		System.out.println("sync : " + count + " , " + (t2 - t1));
		
		Long t3 = System.currentTimeMillis();
		atomicThreads.forEach(t -> t.start());
		atomicThreads.forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Long t4 = System.currentTimeMillis();
		
		System.out.println("atomic : " + atomicCount.get() + " , " + (t4 - t3));
		Long t5 = System.currentTimeMillis();
		longAdderThreads.forEach(t -> t.start());
		longAdderThreads.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Long t6 = System.currentTimeMillis();
		System.out.println("longAdder : " + laCount.intValue() + " , " +  (t6 - t5));
	}

}
