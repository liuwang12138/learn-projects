package com.gf.dp.flyweight;

/**
 * 	��Ԫģʽ���ַ����ײ�ʹ��
 * 
 * String.intern()����ȡ����������ַ���
 *
 */
public class StringFlyweight {
	
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		String str4 = new String("abc");
		
		System.out.println(str1 == str2);						// true		���ǳ�������Ķ���
		System.out.println(str1 == str3);						// false	һ���ǳ�������ģ�һ����new������
		System.out.println(str3 == str4);						// false	��������new������
		System.out.println(str1 == str3.intern());				// true		��߳����أ��ұ߾���intern֮��Ҳ�ǳ�����
		System.out.println(str3.intern() == str4.intern());		// true		���ߴ�����ǳ�����
	}

}
