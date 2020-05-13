package com.gf.juc.part03;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class G08_TransferQueue {
	
	public static void main(String[] args) {
		TransferQueue<String> queue = new LinkedTransferQueue<String>();
		
		
		
		
		new Thread(() -> {
			try {
				System.out.println("ready");
				queue.transfer("a");
				System.out.println("ok");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		new Thread(() -> {
			try {
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		
		
	}

}
