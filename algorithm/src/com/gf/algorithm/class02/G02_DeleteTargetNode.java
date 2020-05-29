package com.gf.algorithm.class02;

import com.gf.algorithm.class02.common.Node;

/**
 * 在给定链表中删除给定值的节点
 */
public class G02_DeleteTargetNode {
	
	public static Node removeTargetNode(Node head, int value) {
		
		while (head != null && head.value == value) {
			head = head.next;
		}
		Node cur = head;
		
		while (cur != null) {
			while (cur.next != null && cur.next.value == value) {
				cur.next = cur.next.next;
			}
			
			cur = cur.next;
		}
		
		return head;
	}
	
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		node1.print();
		
		
		removeTargetNode(node1, 5).print();
		
	}
	

}
