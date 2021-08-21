package solutions.amazon;

import java.util.*;

/**
 * 787 Cheapest Flights Within K stops
 */
public class FindCheapestPrice {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k+2][n];

        for(int i = 0; i <= k + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][src] = 0;
        }

        for(int i = 1; i <= k + 1; i++) {
            for(int[] f : flights) {
                int source = f[0];
                int dest = f[1];
                int price = f[2];

                if(dp[i-1][source] != Integer.MAX_VALUE) {
                    dp[i][dest] = Math.min(dp[i][dest], dp[i-1][source] + price);
                }
            }
        }

        return (dp[k+1][dst] == Integer.MAX_VALUE) ? -1 : dp[k+1][dst];
    }

}
