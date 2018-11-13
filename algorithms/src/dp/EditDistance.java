package dp;

public class EditDistance {
	
	public static void main(String[] args) {
		
		 char[] s1 = "sunday".toCharArray(); 
		 char[] s2 = "saturday".toCharArray(); 
		  
		 System.out.println("minEdits "+minEdits(s1, s2, s1.length, s2.length));
		 System.out.println("dp: minEdits "+minEdits(s1, s2));
		
	}
	static int minEdits(char[] s1, char[] s2, int m, int n) {
		
		if(m == 0 ) {
			return n;
		}
		if(n == 0) {
			return m;
		}
		
		if(s1[m-1] == s2[n-1]) {
			return minEdits(s1, s2, m-1, m-1);
		}else {
			return 1 + Math.min(minEdits(s1, s2, m-1, n), 
					Math.min(minEdits(s1, s2, m, n-1), 
							minEdits(s1, s2, m-1, n-1)));
		}
		
	}
	
	
	static int minEdits(char[] s1, char[] s2) {
		
		int m = s1.length;
		int n = s2.length;
		
		if(m == 0) {
			return n;
		}
		if(n == 0) {
			return m;
		}
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			dp[i][0] = i; 
		}
		for(int i=0;i<=n;i++) {
			dp[0][i] = i;
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1[i-1] == s2[j-1]) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = 1 +  Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
				}
			}
		}
		
		return dp[m][n];
		
	}

}
