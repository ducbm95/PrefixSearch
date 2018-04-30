package com.ducbm.prefixsearch.trie;

import java.util.HashMap;
import java.util.Map;

public class Node {

	private Map<Character, Node> children;
	private String data;

	public Node() {
	}

	public Node(String data) {
		this.data = data;
	}

	public Map<Character, Node> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, Node> children) {
		this.children = children;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void addChild(Character key, Node child) {
		if (children == null) {
			children = new HashMap<Character, Node>();
		}
		children.put(key, child);
	}

	public Node getChild(Character key) {
		if (children == null)
			return null;
		return children.get(key);
	}

}
