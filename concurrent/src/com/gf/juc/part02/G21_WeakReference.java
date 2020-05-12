package com.gf.juc.part02;

import java.lang.ref.WeakReference;

public class G21_WeakReference {
	
	public static void main(String[] args) {
		WeakReference<Object> weakReference = new WeakReference<>(new Object());
		
		System.out.println(weakReference.get());
		
		System.gc();
		System.out.println(weakReference.get());
	}

}
