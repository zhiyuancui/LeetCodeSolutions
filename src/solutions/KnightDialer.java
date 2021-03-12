package solutions;

import java.util.Arrays;

public class KnightDialer {
    public int knightDialer(int n) {
        if(n <= 0) {
            return 0;
        }

        if(n==1) {
            return 10;
        }

        int mod = 1000000007;

        int[][] moves = new int[][]{
                {4,6},{6,8},{7,9},{4,8},{3,9,0},
                {},{1,7,0},{2,6},{1,3},{2,4}};

        int[][] dp = new int[2][10];
        Arrays.fill(dp[0], 1);
        for(int hops = 0; hops < n -1; hops++) {
            Arrays.fill(dp[~hops&1], 0);
            for(int i = 0; i <10; i++) {
                for(int move: moves[i]) {
                    dp[~hops & 1][move] += dp[hops & 1][i];
                    dp[~hops & 1][move] %= mod;
                }
            }
        }

        long ans = 0;
        for(int x : dp[~n & 1]) {
            ans += x;
        }

        return (int)(ans % mod);
    }
}
