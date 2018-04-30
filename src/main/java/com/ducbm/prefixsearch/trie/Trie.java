package com.ducbm.prefixsearch.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ducbm.prefixsearch.PrefixSearch;

public class Trie implements PrefixSearch {

	private Node head;

	public Trie() {
		head = new Node();
	}

	public List<String> search(String prefix, int limit) {
		Node res = head;
		for (Character s : prefix.toCharArray()) {
			res = res.getChild(s);
		}
		return dfs(res, limit);
	}

	public void addWord(String word) {
		Node parent = head;
		for (Character s : word.toCharArray()) {
			Node child = parent.getChild(s);
			if (child == null) {
				child = new Node();
			}
			parent.addChild(s, child);
			parent = child;
		}
		parent.setData(word);
	}

	private List<String> dfs(Node node, int limit) {
		List<String> res = new ArrayList<String>();
		if (node == null) return res;
		
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		while (!stack.isEmpty() && limit > 0) {
			node = stack.pop();
			if (node.getData() != null) {
				res.add(node.getData());
				limit--;
			} 
			
			if (node.getChildren() != null) {
				for (Node child : node.getChildren().values()) {
					stack.push(child);
				}
			}
		}
		return res;
	}

}
