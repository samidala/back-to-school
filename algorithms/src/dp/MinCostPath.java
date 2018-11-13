package dp;

public class MinCostPath {
	
	static int minCostPath(int[][] a, int m, int  n) {
		
		if(m < 0 || n < 0) {
			return Integer.MAX_VALUE;
		}
		if(m == 0 && n == 0 ) {
			return a[m][n];
		}else {
			
			return
					 a[m][n]+  Math.min(minCostPath(a, m-1, n-1),
							Math.min(minCostPath(a, m-1, n), minCostPath(a, m, n-1)));
		}
	}
	
	public static void main(String[] args) {
		  int a[][] = { {1, 2, 3}, 
                  {4, 8, 2}, 
                  {1, 5, 3} }; 
		  
		System.out.println("minCostPath "+minCostPath(a, a.length-1, a[0].length-1));
		System.out.println("dp: minCostPath "+minCostPath(a));
	}
	
	static int minCostPath(int[][] a) {
		
		int m = a.length;
		int n = a[0].length;
		
		int[][] dp = new int[m+1][n+1];
		dp[0][0] = a[0][0];
		
		for(int i=1;i<m;i++) {
			dp[i][0] = dp[i-1][0] + a[i][0];
		}
		
		for(int j=1;j<n;j++) {
			dp[0][j] = dp[0][j-1] + a[0][j];
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				dp[i][j] = a[i-1][j-1] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
			}
		}
		
		return dp[m][n];
		
		
	}

}
