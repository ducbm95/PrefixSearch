package com.ducbm.prefixsearch;

import java.util.UUID;

import com.ducbm.prefixsearch.trie.Trie;

public class Application {

	public static void main(String[] args) {

		long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		PrefixSearch ps = new Trie();
		for (int i = 0; i < 1000; i++) {
			UUID uuid = UUID.randomUUID();
			ps.addWord(uuid.toString());
		}

		long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long actualMemUsed = afterUsedMem - beforeUsedMem;
		System.out.println(1.0 * actualMemUsed / 1024 / 1024);
	}
}
