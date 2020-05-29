package com.gf.algorithm.class02;

import java.util.Stack;

/**
 * 用 O(1) 的时间复杂度，获取栈中的最小值：
 * 
 * 	（一）
 * 		准备两个栈，一个data栈，一个min栈
 * 		两个栈同步上升，data栈入栈，min栈将data栈中入栈的元素和栈顶元素对比，将较小值入栈
 * 		弹栈的时候同步弹出
 * 		要获取最小值，只需要获取min栈的最小值即可
 * 	
 * 	（二）
 * 		<=的时候压入，>不压入
 * 		弹出的时候当data栈弹出的元素和min栈的元素相等的时候，min栈弹出，否则不弹出
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
			throw new RuntimeException("没有最小值");
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
