package arrays;

import java.util.Arrays;

public class CountSmallerElements {
	
	static void smallerElements(int[] a) {

		 
		 int n = a.length;
		 int[] dp = new int[n];
		 Arrays.fill(dp, 0);
		 for(int i=0;i<n;i++) {
			 for(int j=i+1;j<n;j++) {
				 if(a[i] > a[j]) {
					 dp[i] = dp[i] + 1;
				 }
			 }
		 }
		 System.out.println(Arrays.toString(dp));
	
		
	}
	public static void main(String[] args) {
		int a[] =  {12, 1, 2, 3, 0, 11, 4};
		smallerElements(a);
		int b[] =  {5, 4, 3, 2, 1};
		smallerElements(b);
		int c[] = {1, 2, 3, 4, 5};
		smallerElements(c);
	}
	
}
