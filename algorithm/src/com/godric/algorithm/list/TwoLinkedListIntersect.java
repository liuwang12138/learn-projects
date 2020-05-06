package com.godric.algorithm.list;

import com.godric.algorithm.common.Node;

/**
 * @apiNote �������������л�Ҳ�����޻��ĵ�����ͷ�ڵ�head1��head2����ʵ��һ��������������������ཻ���뷵���ཻ�ĵ�һ���ڵ㣬������ཻ���򷵻�null
 * @author Godric
 */
public class TwoLinkedListIntersect {
	
	
	/**
	 * @apiNote �����������û�л������ͷ���һֱ������β�ڵ㣬�������β�ڵ���ͬ����ض��ཻ�����жϵ�һ���ཻ�Ľڵ�
	 * 			����жϵ�һ���ཻ�Ľڵ㣺
	 */
	public static Node doubleNoLoop(Node head1, Node head2) {
		return null;
	}
	
	/**
	 * @apiNote ����һ�������ͷ��㣬�����������л����򷵻���������뻷�ĵ�һ���㣬����޻����򷵻ؿ�
	 */
	public static Node getFirstNodeInCircle(Node head) {
		Node fast = head;
		Node slow = head;
		
		slow = slow.next;
		fast = fast.next.next;
		
		while (fast.next != null && fast.next.next != null && fast != slow) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (slow == fast) {
			// �л����ҵ�һ���뻷�ڵ�
			fast = head;
			while (fast != slow) {
				slow = slow.next;
				fast = fast.next;
			}
			return fast;
		} else {
			// fast.next == null || fast.next.next == null, �޻�������null
			return null;
		}
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15 = new Node(15);
		Node node16 = new Node(16);
		Node node17 = new Node(17);
		Node node18 = new Node(18);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
		node11.next = node12;
		node12.next = node13;
		node13.next = node14;
		node14.next = node15;
		node15.next = node16;
		node16.next = node17;
		node17.next = node18;
		node18.next = node9;
		
		System.out.println(getFirstNodeInCircle(node1).value);
		
	}
	
}