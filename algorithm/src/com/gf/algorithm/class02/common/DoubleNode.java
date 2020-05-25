package com.gf.algorithm.class02.common;

public class DoubleNode {
	int value;
	DoubleNode next;
	DoubleNode pre;
	
	public DoubleNode(int value) {
		this.value = value;
	}
	
	public void print() {
		DoubleNode head = this;
		while (head.next != null) {
			System.out.print(head.value + " -> ");
			head = head.next;
		}
		System.out.println(head.value);
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
		n1.print();
	}
}
