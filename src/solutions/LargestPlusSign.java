package solutions;

import java.util.HashSet;
import java.util.Set;

public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> banned = new HashSet<>();
        int[][] dp = new int[N][N];

        for(int[] mine: mines) {
            banned.add(mine[0]*N + mine[1]);
        }

        int ans = 0, count;

        for(int i = 0; i < N; i++) {
            count = 0;
            for(int j = 0; j < N; j++) {
                count = banned.contains(i*N+ j) ? 0 : count + 1;
                dp[i][j] = count;
            }

            count = 0;
            for(int j = N -1; j >= 0; j--) {
                count = banned.contains(i*N +j) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }

        for(int j = 0; j < N; j++) {
            count = 0;
            for(int i = 0; i < N; i++) {
                count = banned.contains(i*N+j) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }

            count = 0;
            for(int i =N-1; i >= 0; i--) {
                count = banned.contains(i*N+j) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
                ans = Math.max(ans, dp[i][j]);
            }
        }


        return ans;
    }
}
