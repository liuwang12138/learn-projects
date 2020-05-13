package com.gf.juc.part03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class G03_LinkedBlockingQueue {
	
	public static void main(String[] args) {
		
		// add 队列满会抛异常     offer 队列满会返回false   put  队列满会阻塞
		BlockingQueue<Object> queue = new LinkedBlockingQueue<>();
		
		System.out.println("ready to take");
		try {
			queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("over");
	}

}
