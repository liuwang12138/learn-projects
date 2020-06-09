package com.uzgf.leetcode;

import java.util.*;
/**
 * @since 2020/6/9
 * 
 * 429. N�����Ĳ������
 * 
 * ����һ��N������������ڵ�ֵ�Ĳ��������(�������ң�������)
 *
 * ���磬����һ��3������
 * 			1
 * 		/	|	\
 * 	   3	2	 4
 * 	 /	 \
 * 	5	  6
 * ��������������
 * > [
 * >	[1],
 * >	[3, 2, 4],
 * >	[5, 6]
 * > ]
 * 
 * ˵����
 * 		1. ������Ȳ��ᳬ��1000
 * 		2. ���Ľڵ��������ᳬ��5000
 *
 * �㷨˼�룺��������Ȼ�������Ĳ����������������һ����������¼ÿһ��Ľ���
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Q0429_NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (root == null) return result;

    	Queue<Node> queue = new LinkedList<Node>();
    	queue.add(root);
    	
    	while (!queue.isEmpty()) {
    		int size = queue.size();
    		
    		List<Integer> list = new ArrayList<>();
    		while (size > 0) {
    			Node n = queue.poll();
    			list.add(n.val);
    			
    			for (Node child : n.children) {
    				queue.add(child);
    			}
    			size--;
    		}
    		
    		result.add(list);
    	}	
        return result;
    }   
}