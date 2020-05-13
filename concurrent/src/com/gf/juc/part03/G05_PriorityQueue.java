package com.gf.juc.part03;

import java.util.PriorityQueue;
import java.util.Queue;

public class G05_PriorityQueue {
	
	public static void main(String[] args) {
		Queue<Object> queue = new PriorityQueue<>();
		
		
		
		queue.offer("d");
		queue.offer("c");
		queue.offer("a");
		queue.offer("t");
		queue.offer("z");
		queue.offer("g");
		queue.offer("f");
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

}
