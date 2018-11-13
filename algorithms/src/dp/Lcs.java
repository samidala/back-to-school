package dp;


public class Lcs {
	
	static int lcs(char[] s1, char[] s2, int m, int n) {
		
		if(m == 0 || n == 0) {
			return 0;
		}
		
		if(s1[m-1] == s2[n-1]) {
			return 1 + lcs(s1,s2,m-1,n-1);
		}else {
			return Math.max(lcs(s1,s2,m-1,n), lcs(s1, s2, m, n-1));
		}
	}
	
	static int lcs(char[] s1,char[] s2) {
		
		int m = s1.length;
		int n = s2.length;
		
		int[][] dp = new int[m+1][n+1];
		dp[0][0] = 0;
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1[i-1] == s2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[m][n];
		
	}
	
	static int lcsOptimized(char[] s1, char[] s2) {
		int m = s1.length;
		int n = s2.length;
		int bi = 0;
		int[][] dp = new int[2][n+1];
		dp[0][0] = 0;
		
		for(int i=1;i<=m;i++) {
			 bi = i & 1;
			 System.out.println(i +  " bi in itr "+bi);
			for(int j=1;j<=n;j++) {
				if(s1[i-1] == s2[j-1]) {
					dp[bi][j] = dp[1-bi][j-1] + 1;
				}else {
					dp[bi][j] = Math.max(dp[1-bi][j], dp[bi][j-1]);
				}
			}
		}
		System.out.println("bi "+bi);
		return dp[bi][n];
		
	}
	

	
	public static void main(String[] args) {
		 char s1[] = "AGGTABASDFGJHKKJJHDHDHD".toCharArray(); 
		 char s2[] = "GXTXAYBASSFZFSFHSDFJDJD".toCharArray(); 
		 //System.out.println("lcs "+ lcs(s1, s2, s1.length, s2.length));
		 System.out.println("dp: lcs "+ lcs(s1, s2));
		 System.out.println("dp: lcs optimized "+ lcsOptimized(s1, s2));
	}

}
