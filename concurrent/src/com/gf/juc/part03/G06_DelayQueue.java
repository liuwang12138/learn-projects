package com.gf.juc.part03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class G06_DelayQueue {
	
	static BlockingQueue<Task> queue = new DelayQueue<>();
	
	public static void main(String[] args) {
		
		try {
			queue.put(new Task("t1", 2000));
			queue.put(new Task("t2", 3000));
			queue.put(new Task("t3", 4000));
			queue.put(new Task("t4", 1000));
			queue.put(new Task("t5", 500));
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(queue.size());
		
		while (!queue.isEmpty()) {
			try {
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}

class Task implements Delayed {
	String name;
	long time;
	
	public Task(String name, long time) {
		long now = System.currentTimeMillis();
		this.name = name;
		this.time = now + time;
	}
	
	@Override
	public int compareTo(Delayed o) {
		return (int) (this.getDelay(TimeUnit.MICROSECONDS) - o.getDelay(TimeUnit.MICROSECONDS));
	}
	@Override
	public long getDelay(TimeUnit unit) {
		return this.time - System.currentTimeMillis();
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", time=" + time + "]";
	}
	
	
	
	
}
