package com.gf.algorithm.class02;

import java.util.Stack;

/**
 * �� O(1) ��ʱ�临�Ӷȣ���ȡջ�е���Сֵ��
 * 
 * 	��һ��
 * 		׼������ջ��һ��dataջ��һ��minջ
 * 		����ջͬ��������dataջ��ջ��minջ��dataջ����ջ��Ԫ�غ�ջ��Ԫ�ضԱȣ�����Сֵ��ջ
 * 		��ջ��ʱ��ͬ������
 * 		Ҫ��ȡ��Сֵ��ֻ��Ҫ��ȡminջ����Сֵ����
 * 	
 * 	������
 * 		<=��ʱ��ѹ�룬>��ѹ��
 * 		������ʱ��dataջ������Ԫ�غ�minջ��Ԫ����ȵ�ʱ��minջ���������򲻵���
 *
 */
public class G05_GetMinValueInStackWithO1 {
	
	static Stack<Integer> dataStack1 = new Stack<>();
	static Stack<Integer> minStack1 = new Stack<>();
	
	static Stack<Integer> dataStack2 = new Stack<>();
	static Stack<Integer> minStack2 = new Stack<>();
	
	public static void push1(int value) {
		dataStack1.push(value);
		int minBefore = minStack1.isEmpty() ? Integer.MAX_VALUE : minStack1.peek();
		minStack1.push(Math.min(minBefore, value));
	}
	
	public static int pop1() {
		minStack1.pop();
		return dataStack1.pop();
	}
	
	public static int getMin1() {
		return minStack1.peek();
	}
	
	public static void push2(int value) {
		dataStack2.push(value);
		int minBefore = minStack2.isEmpty() ? Integer.MAX_VALUE : minStack2.peek();
		
		if (value <= minBefore) {
			minStack2.push(value);
		}
	}
	
	public static int pop2() {
		if (dataStack2.peek() == minStack2.peek()) {
			minStack2.pop();
		}
		
		return dataStack2.pop();
	}
	
	public static int getMin2() {
		if (minStack2.isEmpty()) {
			throw new RuntimeException("û����Сֵ");
		}
		return minStack2.peek();
	}
	
	public static void main(String[] args) {
		push1(5);
		push2(5);
		push1(6);
		push2(6);
		push1(7);
		push2(7);
		push1(8);
		push2(8);
		System.out.println(getMin1() == getMin2());
		push1(4);
		push2(4);
		System.out.println(getMin1() == getMin2());
		push1(3);
		push2(3);
		System.out.println(getMin1() == getMin2());
		push1(2);
		push2(2);
		System.out.println(getMin1() == getMin2());
		push1(1);
		push2(1);
		System.out.println(getMin1() == getMin2());
		push1(0);
		push2(0);
		System.out.println(getMin1() == getMin2());
		pop1();
		pop2();
		System.out.println(getMin1() == getMin2());
		pop1();
		pop2();
		System.out.println(getMin1() == getMin2());
		
	}
	
	
	
	
	
	
}
