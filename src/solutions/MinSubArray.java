package solutions;

/**
 * 209 Minimum Size Subarray Sum
 */
public class MinSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }

        int left = 0;
        int right = 0;

        int len = Integer.MAX_VALUE;
        int sum = 0;

        for(left = 0; left < nums.length; left++) {
            while(right < nums.length && sum < target) {
                sum += nums[right];
                right++;
            }

            if(sum >= target) {
                len = Math.min(len, right - left);
            }

            sum -= nums[left];
        }


        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
