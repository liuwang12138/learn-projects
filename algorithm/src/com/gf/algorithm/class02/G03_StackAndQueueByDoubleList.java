package com.gf.algorithm.class02;

import com.gf.algorithm.class02.common.DoubleNode;

/**
 * 双向链表实现栈和队列
 *
 */
public class G03_StackAndQueueByDoubleList {

	DoubleNode head = null;
	DoubleNode tail = null;
	
	private void pushFromLeft(int value) {
		if (head == null) {
			head = new DoubleNode(value);
			tail = head;
			return;
		}
		// head不为空，则应该往左新增，然后把head指向新增的节点
		DoubleNode node = new DoubleNode(value);
		node.next = head;
		head.pre = node;
		head = node;
	}
	
	
	private int popFromLeft() {
		if (head == null) {
			throw new RuntimeException("没有更多元素了！");
		}

		DoubleNode resultNode = head;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		
		return resultNode.value;
	}
	
//	private void pushFromRight(int value) {
//		if (tail == null) {
//			tail = new DoubleNode(value);
//			head = tail;
//			return;
//		}
//		
//		DoubleNode node = new DoubleNode(value);
//		tail.next = node;
//		node.pre = tail;
//		tail = node;
//	}
	
	private int popFromRight() {
		if (tail == null) {
			throw new RuntimeException("没有更多元素了！");
		}
		DoubleNode result = tail;
		
		tail = tail.pre;
		if (tail == null) {
			head = null;
		}
		
		return result.value;
	}
	
	public void stackPush(int value) {
		pushFromLeft(value);
	}
	
	public int stackPop() {
		return popFromLeft();
	}
	
	public void queuePush(int value) {
		pushFromLeft(value);
	}
	
	public int queuePop() {
		return popFromRight();
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	
	public static void main(String[] args) {
		G03_StackAndQueueByDoubleList stack = new G03_StackAndQueueByDoubleList();
		stack.stackPush(1);
		stack.stackPush(2);
		stack.stackPush(3);
		stack.stackPush(4);
		stack.stackPush(5);
		stack.stackPush(6);
		stack.stackPush(7);
		stack.stackPush(8);
		
		while (!stack.isEmpty()) {
			System.out.println(stack.stackPop());
		}
		
		System.out.println("======================================================");
		
		G03_StackAndQueueByDoubleList queue = new G03_StackAndQueueByDoubleList();
		queue.queuePush(1);
		queue.queuePush(2);
		queue.queuePush(3);
		queue.queuePush(4);
		queue.queuePush(5);
		queue.queuePush(6);
		queue.queuePush(7);
		queue.queuePush(8);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.queuePop());
		}
		
		
	}

}
