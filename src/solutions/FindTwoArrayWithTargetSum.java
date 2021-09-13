package solutions;

/**
 * 1477 Find Two Non-overlapping Sub-arrays Each With Target Sum
 * https://leetcode-cn.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/solution/xiang-xi-jiang-jie-yi-xia-shuang-zhi-zhe-jjt9/
 */
public class FindTwoArrayWithTargetSum {
    public int minSumOfLengths(int[] arr, int target) {
        int len = arr.length;

        int left = 0;
        int right = 0;
        int sum = 0;

        int min = Integer.MAX_VALUE;

        int[] dp = new int[len + 1];
        dp[0] = len + 1;

        for(right = 0; right < len; right++) {
            sum += arr[right];

            while(sum > target) {
                sum -= arr[left];
                left++;
            }

            if(sum == target) {
                int l = right - left + 1;
                min = Math.min(min, l + dp[left]);
                dp[right+1] = Math.min(dp[right], l);
            } else {
                dp[right + 1] = dp[right];
            }
        }

        return min > len ? -1 : min;
    }
}
