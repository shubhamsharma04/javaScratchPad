package com.opensam.ft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetEqualityTest {

	public static void main(String[] args) {
		Map<Set<String>,Set<String>> map = new HashMap<>();
		Set<String> a = new HashSet<String>();
		a.add("a");
		a.add("b");
		
		map.put(a,a);
		Set<String> b = new HashSet<String>();
		b.add("a");
		b.add("b");
		
		System.out.println(map.containsKey(b));
	}

}
