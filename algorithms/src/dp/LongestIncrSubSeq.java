package dp;

import java.util.Arrays;

public class LongestIncrSubSeq {
	
	static int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
	
	static int maxLisSize = 1;
	
	
	static int lis(int[] a, int n) {
		
		
		
		if(n == 1) {
			return 1;
		}
		int currentMax = 1; 
		for(int i=1;i<n;i++) {
			
			int res = lis(a, i);
			
			if(currentMax  < res + 1 && a[i-1] < a[n-1]) {
				currentMax = res + 1;
			}
			
		}
		
		if(currentMax  > maxLisSize) {
			maxLisSize = currentMax;
		}
		return currentMax;
		
		
	}
	public static void main(String[] args) {
		lis(arr, arr.length);
		System.out.println(" maxLisSize "+maxLisSize);
		System.out.println(" maxLisSize dp "+lis(arr));
	}
	
	
	static int lis(int[] a) {
		int n = a.length;
		
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		
		int lis = 1;
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(a[i] > a[j] && dp[i] < dp[j] + 1) {
					dp[i] =  dp[j] + 1;
				}
			}
		}
		
		for ( int i = 0; i < n; i++ ) 
            if ( lis < dp[i] ) 
            	lis = dp[i]; 
		
		return lis;
	}
	
	

	
}
