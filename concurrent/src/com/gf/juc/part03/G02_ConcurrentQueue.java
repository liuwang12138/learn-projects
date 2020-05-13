package com.gf.juc.part03;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class G02_ConcurrentQueue {
	public static void main(String[] args) {
		Queue<Object> queue = new ConcurrentLinkedQueue<>();
		
		// boolean offer(E e) 表示新增是否成功
		boolean flag = queue.offer(new Object());
		System.out.println(flag);
		queue.offer(new Object());
		
		System.out.println(queue.poll());			// queue.poll()   take and remove
		System.out.println(queue.size());	
		System.out.println(queue.peek());			// queue.peek()	  take but not remove
		System.out.println(queue.size());
		
	}
}
