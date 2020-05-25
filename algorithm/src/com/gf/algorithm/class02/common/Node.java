package com.gf.algorithm.class02.common;

public class Node {

	int value;
	Node next;
	
	public Node(int value) {
		this.value = value;
	}
	
	public void print() {
		Node node = this;
		
		while (node.next != null) {
			System.out.print(node.value + " -> ");
			node = node.next;
		}
		
		System.out.println(node.value);
	}

}
