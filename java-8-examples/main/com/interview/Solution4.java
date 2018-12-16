package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Solution4 {
	
	public static void main(String[] args) {
		
		
	}
	
	
	 public static String isPangram(List<String> strings) {
		 
		 StringBuffer result = new StringBuffer();
		   
		 
		 for(String str: strings) {
			 Set<Character> set = new HashSet<>();
			 str = str.toLowerCase();
			 for(char c: str.toCharArray()) {
				 if('a' <= c &&  c <= 'z') {
					 set.add(c);
					 if(set.size() >= 26) {
						 break;
					 }
	                    	 
	            }
			 }
			 if(set.size() == 26) {
				 result.append(1);
			 }else {
				 result.append(0);
			 }
			 
		 }
		 return result.toString();

	}
	 
	 public static String isPangramV1(List<String> strings) {
		 
		 StringBuffer result = new StringBuffer();
		 
		 
		   
		 
		 for(String str: strings) {
			 Set<Character> set = new HashSet<>();
			 str = str.toLowerCase();
			 for(char c: str.toCharArray()) {
				 if('a' <= c &&  c <= 'z') {
					 set.add(c);
					 if(set.size() >= 26) {
						 break;
					 }
	                    	 
	            }
			 }
			 if(set.size() == 26) {
				 result.append(1);
			 }else {
				 result.append(0);
			 }
			 
		 }
		 return result.toString();

	}
	 
	 

}
