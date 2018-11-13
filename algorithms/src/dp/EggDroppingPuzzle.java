package dp;

public class EggDroppingPuzzle {
	
	
	/**
	 * 
	 * @param n: no of eggs
	 * @param k: no of floors
	 * @return
	 */
	static int minTrials(int n ,int k) {
		
		if(n==1) {
			return k;
		}
		
		if(k == 1 || k == 0) {
			return k;
		}
		
		int minTrials = Integer.MAX_VALUE ;
		
		for(int i=1;i<=k;i++) {
			int res = Math.max(minTrials(n-1, i-1), minTrials(n, k-i));
			if(res < minTrials) {
				minTrials = res;
			}
		}
		return minTrials + 1;
	}
	
	
	static int minTrailsDp(int n, int k) {
		
		
		int[][] dp = new int[n+1][k+1];
		
		
		for(int i=0;i<=n;i++) {
			dp[i][0] = 0;
			dp[i][1] = 1;
		}
		
		for(int i=0;i<=k;i++) {
			dp[1][i] = i;
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=2;j<=k;j++) {
				dp[i][j] = Integer.MAX_VALUE;
				
				for(int x=1;x<=j;x++) {
					int res = 1 + Math.max(dp[i-1][x-1], dp[i][j-x]);
					dp[i][j] = Math.min(dp[i][j], res);
				}
				
			}
		}
		return dp[n][k];
	}

	// Find sum of binomial coefficients xCi 
	// (where i varies from 1 to n). If the sum 
	// becomes more than K 
	static int binomialCoeff(int x, int n, int k) 
	{ 
	    int sum = 0, term = 1; 
	    for (int i = 1; i <= n && sum < k; ++i) { 
	        term *= x - i + 1; 
	        term /= i; 
	        sum += term; 
	    } 
	    return sum; 
	} 
	  
	// Do binary search to find minimum  
	// number of trials in worst case. 
	static int minTrialsbiKo(int n, int k) 
	{ 
	    // Initialize low and high as 1st  
	    //and last floors 
	    int low = 1, high = k; 
	  
	    // Do binary search, for every mid,  
	    // find sum of binomial coefficients and  
	    // check if the sum is greater than k or not. 
	    while (low < high) { 
	        int mid = (low + high) / 2; 
	        if (binomialCoeff(mid, n, k) < k) 
	            low = mid + 1; 
	        else
	            high = mid; 
	    } 
	  
	    return low; 
	} 
	public static void main(String[] args) {
		 int n = 7, k = 100; 
		 //int minTrials =  minTrials(n, k);
		 //System.out.println("minTrials "+minTrials);
		 System.out.println("minTrials "+minTrailsDp(n, k)); 
		 System.out.println("minTrials "+minTrialsbiKo(n, k));  
	}
}
