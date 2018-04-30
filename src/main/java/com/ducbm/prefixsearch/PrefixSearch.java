package com.ducbm.prefixsearch;

import java.util.List;

public interface PrefixSearch {

	List<String> search(String prefix, int limit);
	
	void addWord(String word);
}
