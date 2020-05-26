package com.gf.algorithm.class02.common;

public class DoubleNode {
	public int value;
	public DoubleNode next;
	public DoubleNode pre;
	
	public DoubleNode(int value) {
		this.value = value;
	}
	
	public void print() {
		DoubleNode head = this;
		
		System.out.print("next: ");
		while (head.next != null) {
			System.out.print(head.value + " -> ");
			head = head.next;
		}
		System.out.println(head.value);
		
		
		System.out.print("pre:  ");
		
		StringBuilder sb = new StringBuilder();
		while (head.pre != null) {
			sb.insert(0, " <- " + head.value);
			head = head.pre;
		}
		sb.insert(0, head.value);
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		DoubleNode n1 = new DoubleNode(1);
		DoubleNode n2 = new DoubleNode(2);
		DoubleNode n3 = new DoubleNode(3);
		DoubleNode n4 = new DoubleNode(4);
		DoubleNode n5 = new DoubleNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		n5.pre = n4;
		n4.pre = n3;
		n3.pre = n2;
		n2.pre = n1;
		
		n1.print();
	}
}
