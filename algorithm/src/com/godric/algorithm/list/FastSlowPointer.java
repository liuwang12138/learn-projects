package com.godric.algorithm.list;

import java.util.ArrayList;
import java.util.List;

import com.godric.algorithm.common.Node;

/**
 * @apiNote	����ָ��
 * @author godric
 */
public class FastSlowPointer {
	
	/**
	 * @apiNote	��һ��ͷ�ڵ㣬��������������򷵻��м�ڵ㣬�����ż�������򷵻����Ͻڵ�
	 */
	public static Node midOrUpMidNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			// �����ͷ���Ϊnull���򷵻�null������ĳ���Ϊ1��2���򷵻�ͷ���
			return head;
		}
		
		Node fast = head;
		Node slow = head;
		
		while (fast.next != null && fast.next.next != null) {
			// fastָ�����������������fastָ����������slowָ����һ��
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}
	
	public static int midOrUpMidArrValue(Node head) {
		List<Integer> list = new ArrayList<>();
		
		list.add(head.value);
		while (head.next != null) {
			head = head.next;
			list.add(head.value);
		}
		
		int m = list.size();
		
		// [0, 1, 2, 3, 4]			->			arr[2]	4/2
		// [0, 1, 2, 3, 4, 5]		->			arr[2]	5/2
		// return arr[(m-1)/2]
		return list.get((m-1) / 2);
	}
	
	/**
	 * @apiNote ��һ��ͷ�ڵ㣬������������򷵻��м�ڵ㣬�����ż�������򷵻����½ڵ�
	 */
	public static Node midOrDownMidNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node slow = head;
		Node fast = head;
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if (fast.next == null) {
			return slow;
		} else {
			// fast.next == null
			return slow.next;
		}
	}
	
	/**
	 * @apiNote ��һ��ͷ��㣬ʹ������ķ�ʽ�����м�����½ڵ��value
	 */
	public static int midOrDownMidArrValue(Node head) {
		if (head == null || head.next == null) {
			return head.value;
		}
		
		List<Integer> list = new ArrayList<>();
		list.add(head.value);
		while (head.next != null) {
			head = head.next;
			list.add(head.value);
		}
		
		int m = list.size();
		
		// 0, 1, 2, 3, 4, 5			->	3
		// 0, 1, 2, 3, 4, 5, 6		->	3
		
		return list.get(m/2);
	}
	
	/**
	 * @apiNote ��һ��ͷ��㣬�������ȷ����е�ǰһ����ż�����ȷ������ص�ǰһ��
	 */
	public static Node midOrUpMidBeforeNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		
		return null;
	}
	
	/**
	 * Math.random()	[0, 1)
	 * Math.random() * (maxSize + 1)		[0, maxSize+1)
	 * (int) Math.random() * (maxSize + 1)	[0, maxSize]		 
	 */
	public static Node getLinkedList(int maxValue, int maxSize) {
		int size =	(int)(Math.random() * (maxSize + 1));
	
		Node head = new Node((int)(Math.random() * (maxValue + 1)));
		Node cur = head;
		
		while (--size > 0) {
			Node node = new Node((int)(Math.random() * (maxValue + 1)));
			cur.next = node;
			cur = node;
		}
		
		return head;
	}
	
	
	public static void main(String[] args) {
		int maxValue = 10000;
		int maxSize = 10000;
		int testTimes = 10000;
		
		
		while (testTimes-- > 0) {
			Node head = getLinkedList(maxValue, maxSize);
			
//			int firstValue = midOrUpMidNode(head).value;
//			int secondValue = midOrUpMidArrValue(head);
			
			
			int firstValue = midOrDownMidArrValue(head);
			int secondValue = midOrDownMidArrValue(head);
			
			if (firstValue != secondValue) {
				System.out.println("wrong!");
				return;
			}
		}
		
		System.out.println("nice");
	}
	
	
	
	
}
