package com.gf.dp.flyweight;

/**
 * 	享元模式，字符串底层使用
 * 
 * String.intern()，获取常量池里的字符串
 *
 */
public class StringFlyweight {
	
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		String str4 = new String("abc");
		
		System.out.println(str1 == str2);						// true		都是常量池里的对象
		System.out.println(str1 == str3);						// false	一个是常量池里的，一个的new出来的
		System.out.println(str3 == str4);						// false	两个都是new出来的
		System.out.println(str1 == str3.intern());				// true		左边常量池，右边经过intern之后也是常量池
		System.out.println(str3.intern() == str4.intern());		// true		两边处理后都是常量池
	}

}
