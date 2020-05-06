package com.godric.algorithm.test;

public class Test {
	
	private static class Node {
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		
		Node a = new Node(3);
		Node b = new Node(2);
		Node c = new Node(1);
		
		a.next = b;
		b.next = c;
		c = null;
		System.out.println(b.next.value);
	}

}
