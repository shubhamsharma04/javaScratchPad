package com.scratchpad.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class ServicePartThree {

	public void compareStrings() {
		System.out.println("cj9quwxICXrGuamJ20TCqXyACMlnbR1u".compareTo("c25ddd596aa7c81fa12378fa725f706d54325d12"));
	}

	public void cartesianProduct() {

		Set<String> first = new HashSet<String>();
		first.add("cat");
		first.add("sat");
		Set<String> second = new HashSet<String>();
		second.add("on");
		second.add("the");
		Set<String> third = new HashSet<String>();
		third.add("roof");
		List<Set<String>> l = new ArrayList<Set<String>>();
		// l.add(first);
		l.add(second);
		// l.add(third);
		Set<List<String>> s = com.google.common.collect.Sets.cartesianProduct(l);
		for (List<String> lis : s) {
			for (String str : lis) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}

}
