package com.gf.juc.part03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
//import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
//import java.util.concurrent.ConcurrentHashMap;

/**
 * 100个线程往HashTable中去插入100_0000条数据
 * 测试耗时
 */
public class G01_HashTable_HashMap_SynchronizedHashMap_ConcurrentHashMap {
	
	public static final int TOTAL_COUNT = 100_0000;
	
	public static final int THREAD_COUNT = 100;
	
	public static final int EACH_SIZE = TOTAL_COUNT / THREAD_COUNT;
	
//	public static Map<UUID, UUID> map = new Hashtable<>();				// 100_0000, 422									1622
//	public static Map<UUID, UUID> map = new HashMap<>();				// 线程不安全，没有意义
	public static Map<UUID, UUID> map = Collections.synchronizedMap(new HashMap<>());		// 100_0000, 493				1614
//	public static Map<UUID, UUID> map = new ConcurrentHashMap<>();		// 100_0000, 413, 635								450
	
	static UUID[] keys = new UUID[TOTAL_COUNT];
	static UUID[] values = new UUID[TOTAL_COUNT];
	
	static {
		for (int i=0; i<TOTAL_COUNT; i++) {
			UUID key = UUID.randomUUID();
			UUID value = UUID.randomUUID();
			keys[i] = key;
			values[i] = value;
		}
	}
	
	public static void main(String[] args) {
		
		List<Thread> list = new ArrayList<>();
		
		for (int i=0; i<THREAD_COUNT; i++) {
			int start = i * EACH_SIZE;
			list.add(new Thread(() -> {
				for (int j=start; j<start+EACH_SIZE; j++) {
					map.put(keys[j], values[j]);
				}
			}));
		}
		
		long startTime = System.currentTimeMillis();
		list.forEach(t -> t.start());
		
		list.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long endTime = System.currentTimeMillis();
		
		System.out.println(map.size() + ", " + (endTime - startTime));

		long readStartTime = System.currentTimeMillis();
		for (int i=0; i<10000_0000; i++) {
			map.get(keys[10]);
		}
		long readEndTime = System.currentTimeMillis();
		
		System.out.println(readEndTime - readStartTime);
		
		
	}
	
}
