package solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 764. Largest Plus Sign
 * https://leetcode-cn.com/problems/largest-plus-sign/solution/javadong-tai-gui-hua-jian-dan-yi-dong-by-dan-huang/
 */
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][][] dp = new int[n][n][4];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 4; k++) {
                    dp[i][j][k] = 1;
                }
            }
        }

        for(int[] point : mines) {
            for(int k = 0; k < 4; k++) {
                dp[point[0]][point[1]][k] = 0;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                if(dp[i][j][0] == 1) {
                    dp[i][j][0] = dp[i][j-1][0] + 1;
                    dp[i][j][1] = dp[i-1][j][1] + 1;
                }
            }
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                if(dp[i][j][2] == 1) {
                    dp[i][j][2] = dp[i][j+1][2] + 1;
                    dp[i][j][3] = dp[i+1][j][3] + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = Math.min(dp[i][j][0], Math.min(dp[i][j][1], Math.min(dp[i][j][2], dp[i][j][3])));
                res = Math.max(res, k);
            }
        }
        return res;

    }
}
