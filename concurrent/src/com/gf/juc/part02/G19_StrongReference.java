package com.gf.juc.part02;

import java.io.IOException;

/**
 *  	ǿ�������������ã�
 *  		ǿ���ã�ֻҪû��ָ��ָ��ͻ���
 *  		�����ã��ڴ治���õ�ʱ������
 *  		�����ã�ֻҪ��ϵͳgc�ͻ����
 *  		�����ã�
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
