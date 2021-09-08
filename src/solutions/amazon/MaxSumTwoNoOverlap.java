package solutions.amazon;

/**
 * 1031 Maximum Sum of Two Non-Overlapping Subarrays
 * https://leetcode-cn.com/problems/maximum-sum-of-two-non-overlapping-subarrays/solution/dong-tai-gui-hua-qian-zhui-he-by-zhu-leg-a2oj/
 */
public class MaxSumTwoNoOverlap {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] sums = new int[nums.length + 1];

        for(int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }

        if(firstLen > secondLen) {
            int temp = firstLen;
            firstLen = secondLen;
            secondLen = temp;
        }

        int[][] dp = new int[nums.length+1][2];

        int max = 0;

        for(int i = firstLen; i <= nums.length; i++) {
            int firstSum = sums[i] - sums[i-firstLen];

            dp[i][0] = Math.max(dp[i-1][0], firstSum);

            max = Math.max(max, firstSum + dp[i-firstLen][1]);

            if(i >= secondLen) {
                int secondSum = sums[i] - sums[i-secondLen];
                dp[i][1] = Math.max(dp[i-1][1], secondSum);
                max = Math.max(max, secondSum + dp[i-secondLen][0]);
            }
        }

        return max;
    }
}
