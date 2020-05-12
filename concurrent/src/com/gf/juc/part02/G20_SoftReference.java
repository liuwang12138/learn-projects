package com.gf.juc.part02;

import java.lang.ref.SoftReference;

/**
 * ????????
 * -Xms20M -Xmx20M
 *
 */
public class G20_SoftReference {
	public static void main(String[] args) {
		SoftReference<byte[]> m = new SoftReference<>(new byte[10 * 1024 * 1024]);			// 10MB
		
		System.out.println(m.get());
		System.gc();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(m.get());
		
//		byte[] b = new byte[15 * 1024 * 1024];
		System.out.println(m.get());
		
		
	}
}
