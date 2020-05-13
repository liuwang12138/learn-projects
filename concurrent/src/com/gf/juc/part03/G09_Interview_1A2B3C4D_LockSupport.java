package com.gf.juc.part03;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport й╣ож
 */
public class G09_Interview_1A2B3C4D_LockSupport {
	
	static Thread t1;
	static Thread t2;
	
	public static void main(String[] args) {
		char[] a = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
		
		t1 = new Thread(() -> {
			for (char ca : a) {
				System.out.print(ca);
				LockSupport.unpark(t2);
				LockSupport.park();
			}
		});
		
		t2 = new Thread(() -> {
			for (char cb : b) {
				LockSupport.park();
				System.out.print(cb);
				LockSupport.unpark(t1);
			}
		});
		
		t1.start();
		t2.start();
		
	}

}
