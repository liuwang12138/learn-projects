package com.gf.juc.part02;

import java.io.IOException;

/**
 *  	强软弱虚四种引用：
 *  		强引用：只要没有指针指向就回收
 *  		软引用：内存不够用的时候会回收
 *  		弱引用：只要有系统gc就会回收
 *  		虚引用：
 *
 */
public class G19_StrongReference {
	
	public static void main(String[] args) {
//		M m = new M();
//		m = null;
		System.gc();
//		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class M {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize...");
	}
	
}
