package solutions;

public class PaintFence {

	/**
	 * Reference to: http://www.cnblogs.com/fenshen371/p/5767774.html
	 * @param n
	 * @param k
	 * @return
	 */
	public int numWays(int n, int k) {
		if(n == 0) return 0;
        else if(n == 1) return k;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k + k * (k-1);
        
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-2]*(k-1) + dp[i-1]*(k-1);
        }
        
        return dp[n];
    }
}
