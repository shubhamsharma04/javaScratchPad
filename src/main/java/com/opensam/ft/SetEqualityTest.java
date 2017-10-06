package com.opensam.ft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
		b.add("b");
		b.add("a");
		
		System.out.println(map.containsKey(b));
		
		Set<Set<String>> c = new HashSet<Set<String>>();
		c.add(a);
		System.out.println(c.contains(b));
		
		List<String> list = new ArrayList<>();
		
		list.add("a");
		list.add("b");
		list.add("c");
	}

}
