package com.gf.algorithm.class02;

import com.gf.algorithm.class02.common.DoubleNode;
import com.gf.algorithm.class02.common.Node;

/**
 * ·´×ªÁ´±í
 */
public class G01_ReverseLinkedList {

	public static Node reverseLinkedList(Node head) {
		if (head == null) {
			return null;
		}
		Node pre = null;
		Node next = head.next;
		while (next != null) {
			head.next = pre;
			pre = head;
			head = next;
			next = next.next;
		}
		head.next = pre;
		return head;
	}
	
	public static DoubleNode reverseDoubleList(DoubleNode head) {
		if (head == null) {
			return null;
		}
		
		DoubleNode pre = null;
		DoubleNode next = head.next;
		while (next != null) {
			head.next = pre;
			head.pre = next;
			
			pre = head;
			head = next;
			next = next.next;
		}
		
		head.next = pre;
		head.pre = null;
		
		return head;
	}
	
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		node1.print();
		reverseLinkedList(node1).print();
		
		
		
		DoubleNode doubleNode1 = new DoubleNode(1);
		DoubleNode doubleNode2 = new DoubleNode(2);
		DoubleNode doubleNode3 = new DoubleNode(3);
		DoubleNode doubleNode4 = new DoubleNode(4);
		DoubleNode doubleNode5 = new DoubleNode(5);
		DoubleNode doubleNode6 = new DoubleNode(6);
		
		doubleNode1.next = doubleNode2;
		doubleNode2.next = doubleNode3;
		doubleNode3.next = doubleNode4;
		doubleNode4.next = doubleNode5;
		doubleNode5.next = doubleNode6;
		
		doubleNode6.pre = doubleNode5;
		doubleNode5.pre = doubleNode4;
		doubleNode4.pre = doubleNode3;
		doubleNode3.pre = doubleNode2;
		doubleNode2.pre = doubleNode1;
		
		doubleNode1.print();
		reverseDoubleList(doubleNode1).print();
	}

}
