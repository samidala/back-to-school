package dp;

public class FriendsPairingProblem {
	
	static int pair(int n) {
		
		if(n == 0) {
			return 1;
		}
		if(n == 1) {
			return 1;
		}
		
		
		return pair(n-1) + ((n-1) * pair(n-2));
	}
	
	static int pairDp(int n) {
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3;i<=n;i++) {
			dp[i] = dp[i-1] + ((i-1) * dp[i-2]);
		}
		return dp[n];
	}
	public static void main(String[] args) {
		int n = 5;
		int noOfWays = pair(n);
		System.out.println("noOfWays "+noOfWays);
		noOfWays = pairDp(n);
		System.out.println("noOfWays "+noOfWays);
	}

}
