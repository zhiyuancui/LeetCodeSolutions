package solutions;

/**
 * https://leetcode-cn.com/problems/last-stone-weight-ii/solution/gong-shui-san-xie-xiang-jie-wei-he-neng-jgxik/
 * 1049 Lst Stone Weight II
 */
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        if(stones == null || stones.length == 0) {
            return 0;
        }

        int len = stones.length;

        int sum = 0;
        for(int i : stones) {
            sum += i;
        }

        int target = sum / 2;

        int[][] dp = new int[len+1][target + 1];

        for(int i = 1; i <= len; i++) {
            int stone = stones[i-1];
            for(int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= stone) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-stone] + stone);
                }
            }
        }

        return Math.abs(sum - dp[len][target] - dp[len][target]);
    }
}

