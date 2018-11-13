package arrays;

import java.util.Stack;

public class LeadersInArray {
	
	public static void leadersInArray(int[] a) {
		
		int n = a.length;
		int greatestSeenSoFar = Integer.MIN_VALUE;
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=n-1;i>=0;i--) {
			if(a[i] > greatestSeenSoFar) {
				greatestSeenSoFar = a[i];
				stack.push(greatestSeenSoFar);
				//System.out.println(greatestSeenSoFar);
				
			}
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		
		
	}
	public static void main(String[] args) {
		int a[] = {16, 17, 4, 3, 5, 2};
		leadersInArray(a);
	}
	
	

}
