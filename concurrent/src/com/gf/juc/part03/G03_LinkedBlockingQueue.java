package com.gf.juc.part03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class G03_LinkedBlockingQueue {
	
	public static void main(String[] args) {
		
		// add �����������쳣     offer �������᷵��false   put  ������������
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
