package com.gf.algorithm.class05;


import java.util.HashMap;

/**
 * ǰ׺�� (�ֵ���)
 * 	1. �����ַ������ַ���ǰ����ļӵ�һ�ö������
 * 	2. �ַ�����·�ϣ��ڵ�����ר����������(��������pass��endֵ)
 * 	3. ������������������ӣ����û��·���½��������·�͸���
 * 	4. ��;�ڵ��passֵ����1��ÿ���ַ�������ʱ�����Ľڵ�endֵ����1
 * 
 * �������ǰ׺��صĲ�ѯ
 * 
 * ǰ׺��·��ʵ�ַ�ʽ
 * 	1. �̶�����ʵ��	@see Node1
 * 	2. ��ϣ��ʵ��		@see Node2
 *
 */
public class C01_TrieTree {
	
	private Node1 root = new Node1();
	
	/**
	 * �ַ�����ֻ����a~z
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
	 * ɾ��һ��word����
	 * @note ��ʱ��һ��·������ȫ��Ҫ����Ҫɾ���Ĺ�������ʱ��飬���passΪ0����ֱ���ÿգ����������� 
	 */
	public void delete1(String word) {
		if (word == null) return;

		if (search1(word) != 0) {
			// ֻ�����ҵ�����ɾ��
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
	 * word�������֮ǰ���������
	 * @note �������һ���ڵ��endֵ
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
	 * ���м�����ַ����У��м�������pre����ַ�����Ϊǰ׺��
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
