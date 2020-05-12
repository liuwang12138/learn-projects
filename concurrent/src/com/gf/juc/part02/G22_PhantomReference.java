//package com.gf.juc.part02;
//
//import java.lang.ref.PhantomReference;
//import java.lang.ref.Reference;
//import java.lang.ref.ReferenceQueue;
//import java.util.ArrayList;
//import java.util.List;
//
//public class G22_PhantomReference {
//	
//	static List<Object> list = new ArrayList<>();
//	
//	final static ReferenceQueue<Object> QUEUE = new ReferenceQueue<>();
//	
//	public static void main(String[] args) {
//		
//		PhantomReference<Object> phantomReference = new PhantomReference<>(new Object(), QUEUE);
//		
//		new Thread(() -> {
//			while (true) {
//				list.add(new byte[1024*1024]);
//				System.out.println("add ...");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();
//		
//		new Thread(() -> {
//			while (true) {
//				Reference<? extends Object> poll = QUEUE.poll();
//				
//				if (poll != null) {
//					System.out.println("-----------虚引用被回收-----------");
//				}
//			}
//		}).start();
//		
//	}
//
//}
