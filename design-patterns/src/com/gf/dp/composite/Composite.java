package com.gf.dp.composite;

import java.util.*;

public class Composite {
	
	/**
	 * root
	 * --B1
	 * ----B11
	 * ------L111
	 * ------L112	
	 * ----B12
	 * --B2
	 * ----B21
	 * ----B22
	 * --B3 
	 */
	public static void main(String[] args) {
		BranchNode root = new BranchNode("root");
		
		BranchNode b1 = new BranchNode("B1");
		BranchNode b2 = new BranchNode("B2");
		BranchNode b3 = new BranchNode("B3");
		
		BranchNode b11 = new BranchNode("B11");
		BranchNode b12 = new BranchNode("B12");
		BranchNode b21 = new BranchNode("B21");
		BranchNode b22 = new BranchNode("B22");
		
		LeafNode l111 = new LeafNode("L111");
		LeafNode l112 = new LeafNode("L112");
		
		
		root.add(b1).add(b2).add(b3);
		b1.add(b11).add(b12);
		b2.add(b21).add(b22);
		b11.add(l111).add(l112);
		
		tree(root, 0);
	}
	
	private static void tree(Node n, int level) {
		
		for (int i=0; i<level; i++) System.out.print("--");
		n.print();
		
		if (n instanceof BranchNode) {
			for (Node node : ((BranchNode)n).nodeList) tree(node, level+1);
		}
	}

}

interface Node {
	void print();
}

class BranchNode implements Node {
	
	List<Node> nodeList = new ArrayList<>();
	String name;
	
	@Override
	public void print() {
		System.out.println(name);
	}
	
	public BranchNode add(Node n) {
		nodeList.add(n);
		return this;
	}

	public BranchNode(String name) {
		this.name = name;
	}
}

class LeafNode implements Node {
	
	String name;
	
	@Override
	public void print() {
		System.out.println(name);
	}
	
	public LeafNode(String name) {
		this.name = name;
	}
}
