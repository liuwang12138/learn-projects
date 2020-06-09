package com.uzgf.leetcode;

import java.util.*;
/**
 * @since 2020/6/9
 * 
 * 429. N叉树的层序遍历
 * 
 * 给定一个N叉树，返回其节点值的层序遍历。(即从左到右，逐层遍历)
 *
 * 例如，给定一个3叉树：
 * 			1
 * 		/	|	\
 * 	   3	2	 4
 * 	 /	 \
 * 	5	  6
 * 返回其层序遍历：
 * > [
 * >	[1],
 * >	[3, 2, 4],
 * >	[5, 6]
 * > ]
 * 
 * 说明：
 * 		1. 树的深度不会超过1000
 * 		2. 树的节点总数不会超过5000
 *
 * 算法思想：整体上依然利用树的层序遍历，但是利用一个变量，记录每一层的结束
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