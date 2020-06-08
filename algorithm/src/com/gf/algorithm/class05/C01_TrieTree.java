package com.gf.algorithm.class05;


import java.util.HashMap;

/**
 * 前缀树 (字典树)
 * 	1. 单个字符串，字符从前到后的加到一棵多叉树上
 * 	2. 字符放在路上，节点上有专属的数据项(常见的是pass和end值)
 * 	3. 所有样本都会这样添加，如果没有路就新建，如果有路就复用
 * 	4. 沿途节点的pass值增加1，每个字符串结束时来到的节点end值增加1
 * 
 * 可以完成前缀相关的查询
 * 
 * 前缀树路的实现方式
 * 	1. 固定数组实现	@see Node1
 * 	2. 哈希表实现		@see Node2
 *
 */
public class C01_TrieTree {
	
	private Node1 root = new Node1();
	
	/**
	 * 字符种类只能是a~z
	 * @author 12
	 *
	 */
	private static class Node1 {
		int pass;
		int end;
		Node1[] nexts;
		
		Node1() {
			nexts = new Node1[26];
		}
	}
	
	private static class Node2 {
		int pass;
		int end;
		HashMap<Integer, Node2> nexts;
		
		Node2() {
			nexts = new HashMap<>();
		}
	}
	
	public void insert1(String word) {
		if (word == null) return;
		
		char[] str = word.toCharArray();
		Node1 cur = root;
		cur.pass++;
		
		for (char c : str) {
			int path = c - 'a';
			if (cur.nexts[path] == null) {
				cur.nexts[path] = new Node1();
			}
			cur.nexts[path].pass++;
			cur = cur.nexts[path];
		}
		
		cur.end++;
	}
	
	/**
	 * 删除一条word数据
	 * @note 有时候一条路可以完全不要，需要删除的过程中随时检查，如果pass为0，则直接置空，不再往下走 
	 */
	public void delete1(String word) {
		if (word == null) return;

		if (search1(word) != 0) {
			// 只有能找到，才删除
			char[] str = word.toCharArray();
			Node1 cur = root;
			cur.pass--;

			for (char c : str) {
				int path = c - 'a';
				
				if (cur.pass == 0) {
					cur.nexts[path] = null;
					return;
				}

				cur.nexts[path].pass--;
				cur = cur.nexts[path];
			}
			
			cur.end--;
		}
		
	}
	
	/**
	 * word这个单词之前插入过几次
	 * @note 返回最后一个节点的end值
	 */
	public int search1(String word) {
		char[] str = word.toCharArray();
		Node1 cur = root;
		for (char c : str) {
			int path = c - 'a';
			if (cur.nexts[path] == null) {
				return 0;
			}
			cur = cur.nexts[path];
		}
		
		return cur.end;
	}
	
	/**
	 * 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
	 */
	public int prefixNumber1(String pre) {
		char[] str = pre.toCharArray();
		Node1 cur = root;
		for (char c : str) {
			int path = c - 'a';
			if (cur.nexts[path] == null) {
				return 0;
			}
			cur = cur.nexts[path];
		}
		
		return cur.pass;
	}
	
	public static void main(String[] args) {
		C01_TrieTree c = new C01_TrieTree();
		c.insert1("abc");
		c.insert1("ab");
		c.insert1("fgd");
		c.insert1("ad");
		c.insert1("qat");
		c.insert1("qat");
		
		// 2
		System.out.println(c.prefixNumber1("ab"));
		
		// 3
		System.out.println(c.prefixNumber1("a"));
		
		// 2
		System.out.println(c.search1("qat"));
		
		// 1
		System.out.println(c.search1("abc"));
		
		System.out.println("====================");
		
		c.delete1("qat");
		// 1
		System.out.println(c.search1("qat"));
		
		c.delete1("abc");
		// 1
		System.out.println(c.prefixNumber1("ab"));
		
		// 2
		System.out.println(c.prefixNumber1("a"));
		
	}

}
