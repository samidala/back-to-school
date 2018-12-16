package com.techdisqus.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if(o2.equals("others")) {
			return Integer.MIN_VALUE;
		}
		if(o1.equals("others")) {
			return Integer.MAX_VALUE;
		}
		return o1.compareTo(o2);
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("shiva");
		list.add("axaa");
		list.add("ava");
		list.add("others");
		list.add("tyas");
		list.add("aaa");
		
		Collections.sort(list, new CustomComparator());
		System.out.println(list);
		
		List<String> list1 = new ArrayList<>();
		list1.add("shiva");
		list1.add("axaa");
		list1.add("ava");
		list1.add("others");
		list1.add("tyas");
		list1.add("aaa");
		
		list1.sort((s1,s2) -> {if(s2.equals("others")) {
			return Integer.MIN_VALUE;
		}
		if(s1.equals("others")) {
			return Integer.MAX_VALUE;
		}
		return s1.compareTo(s2);} );
		System.out.println(list1);
		
	}
	
	

}
