package dp;

public class CoinChangeProblem {
	
	public static void main(String[] args) {
		
		int a[] = {1,2,3};
		int k = 4;
		
		int count = countWays(a, k, a.length);
		System.out.println("noOfWays "+count);
		System.out.println("noOfWays DP "+countWays(a, k));
		
	}
	
	static int countWays(int[] a, int k,int n) {
		
		if(k==0) {
			return 1;
		}
		
		if(k < 0) {
			return 0;
		}
		
		if(n <= 0) {
			return 0;
		}
		
		return countWays(a, k - a[n-1], n) + countWays(a, k, n-1);
	}
	
	static int countWays(int[] a, int k) {
		
		int n = a.length;
		
		int[] dp = new int[k+1];
		
		
		dp[0] = 1;
		
		for(int i=0;i<n;i++) {
			for(int j=a[i];j<=k;j++) {
				
				dp[j] = dp[j] + dp[j-a[i]];
				
				
			}
		}
		
		return dp[k];
		
	}

}
