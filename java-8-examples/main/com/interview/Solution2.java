package com.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution2 {
	
	public static void main(String[] args) {
		
		
	}
	
	 private class SinglyLinkedListNode {
	         int data;
	         SinglyLinkedListNode next;
	         
	         
	 }
	
	 public static SinglyLinkedListNode distinct(SinglyLinkedListNode head) {
		 
	        Set<Integer> set = new HashSet<>(); 
	      
	        SinglyLinkedListNode currentNode = head; 
	        SinglyLinkedListNode prevNode = null; 
	        while (currentNode != null)  
	        { 
	            int curval = currentNode.data; 
	              
	            if (set.contains(curval)) { 
	            	prevNode.next = currentNode.next; 
	            } else { 
	            	set.add(curval); 
	            	prevNode = currentNode; 
	            } 
	            currentNode = currentNode.next; 
	        }
	        return head;
	 }

}
