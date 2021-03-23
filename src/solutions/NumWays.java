package solutions;

public class NumWays {
    public int numWays(int steps, int arrLen) {
        int mod = 1000000007;

        int[][] dp = new int[steps][arrLen];
        dp[0][0] = 1;
        dp[0][1] = 1;

        for(int i = 1; i < steps; i++) {
            for(int j = 0; j <= Math.min(arrLen-1, steps -i); j++) {
                long ans = dp[i-1][j];
                if(j > 0) {
                    ans = (ans + dp[i-1][j-1]) % mod;
                }
                if(j < arrLen - 1) {
                    ans = (ans + dp[i-1][j+1]) % mod;
                }
                dp[i][j] = (int)ans;
            }
        }
        return dp[steps-1][0];
    }
}
