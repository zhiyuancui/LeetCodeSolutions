package solutions;

import java.util.Arrays;

/**
 * 1547 Minimum Cost to Cut Stick
 */
public class MinimumCostToCutStick {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int[] newCuts = new int[cuts.length + 2];

        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        for(int i = 1; i <= cuts.length; i++) {
            newCuts[i] = cuts[i-1];
        }

        int[][] dp = new int[newCuts.length][newCuts.length];

        for(int i = cuts.length; i >= 1; i--) {
            for(int j = i; j <= cuts.length; j++) {
                dp[i][j] = i == j ? 0 : Integer.MAX_VALUE;
                for(int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k-1] + dp[k+1][j]);
                }

                dp[i][j] += newCuts[j+1] - newCuts[i-1];
            }
        }

        return dp[1][cuts.length];
    }
}
