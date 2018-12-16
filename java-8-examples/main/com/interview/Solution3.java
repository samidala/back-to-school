package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Solution3 {
	
	public static void main(String[] args) {
		
		
	}
	
	
	  public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
		    
		  List<Integer> result = new ArrayList<>();
		  int aSize = a.size();
		  int bSize = b.size();
		  
		  int i = 0;
		  int j = 0;
		  
		  while(i < aSize && j < bSize) {
			  if(a.get(i) < b.get(j)) {
				  result.add(a.get(i));
				  i++;
			  }else if(a.get(i) > b.get(j)) {
				  result.add(b.get(j));
				  j++;
			  }else {
				  result.add(a.get(i));
				  result.add(b.get(j));
				  i++;
				  j++;
			  }
		  }
		  
		  while(i < aSize) {
			  result.add(a.get(i));
			  i++;
		  }
		  while(j < bSize) {
			  result.add(b.get(j));
			  j++;
		  }
		  
		  return result;
		  

	}

}
