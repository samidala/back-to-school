package com.interview;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Solution {
	
	public static void main(String[] args) {
		
		String s = "It is a pleasant day today";
		System.out.println(longestEvenWord(s));
		System.out.println(longestEvenWordV1(s));
		
	}
	
	public static String longestEvenWord(String sentence) {
	    
		String words[] = sentence.split(" ");
		String maxEvenLengthWord ="00";
		int maxEvenLength = Integer.MIN_VALUE;
		for(String word: words) {
			if(word.length() % 2 == 0 && word.length() > maxEvenLength) {
				maxEvenLength = word.length();
				maxEvenLengthWord = word;
			}
		}
		return maxEvenLengthWord;
	}
	
	public static String longestEvenWordV1(String sentence) {
	    
		String words[] = sentence.split(" ");
		String maxEvenLengthWord ="00";
		
		String res = Arrays.stream(words)
				.filter(w -> w.length() % 2 == 0)
				.reduce((u,v) -> u.length() > v.length() ? u : v).orElse(maxEvenLengthWord);
		
		return res;
		
		//return maxEvenLengthWord;
	}

}
