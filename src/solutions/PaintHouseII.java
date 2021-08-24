package solutions;

/**
 * 256 Paint House II
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }

        int n = costs.length;
        int k = costs[0].length;

        Integer leastMin = null;
        Integer secondMin = null;

        int[][] dp = new int[n][k];
        for(int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
            if(leastMin == null || dp[0][i] < dp[0][leastMin]) {
                secondMin = leastMin;
                leastMin = i;
            } else if(secondMin == null || dp[0][i] < dp[0][secondMin]) {
                secondMin = i;
            }
        }

        for(int i = 1; i < n; i++) {
            int leastIndex = leastMin;
            int secondIndex = secondMin;

            leastMin = null;
            secondMin = null;

            for(int j = 0; j < k; j++) {
                if( j != leastIndex) {
                    dp[i][j] = dp[i-1][leastIndex] + costs[i][j];
                } else {
                    dp[i][j] = dp[i-1][secondIndex] + costs[i][j];
                }

                if(leastMin == null || dp[i][j] < dp[i][leastMin]) {
                    secondMin = leastMin;
                    leastMin = j;
                } else if(secondMin == null || dp[i][j] < dp[i][secondMin]) {
                    secondMin = j;
                }
            }
        }

        return dp[n-1][leastMin];
    }
}
