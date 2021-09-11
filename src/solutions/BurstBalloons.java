package solutions;

/**
 * 312 Burst Balloons
 *
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] copy = new int[nums.length + 2];

        for(int i = 0; i < nums.length; i++) {
            copy[i+1] = nums[i];
        }

        copy[0] = 1;
        copy[copy.length - 1] = 1;

        int len = copy.length;

        int[][] dp = new int[len][len];

        for(int width = 2; width < len; width++) {
            for(int left = 0; left + width < len; left++) {
                int right = left + width;
                for(int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right], dp[left][k] + dp[k][right] + copy[left]*copy[right]*copy[k]);
                }
            }
        }

        return dp[0][len-1];
    }
}
