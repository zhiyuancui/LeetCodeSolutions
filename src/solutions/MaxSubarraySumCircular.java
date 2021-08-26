package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 918 Maximum Sum Circular Subarray
 */
public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int x : nums)
            total += x;

        int min_sum = Integer.MAX_VALUE;
        int max_sum = Integer.MIN_VALUE;

        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < n; i++){
            sum1 += nums[i];
            min_sum = Math.min(min_sum, sum1);
            if(sum1 > 0)
                sum1 = 0;

            sum2 += nums[i];
            max_sum = Math.max(max_sum, sum2);
            if(sum2 < 0)
                sum2 = 0;
        }

        if(max_sum < 0) return max_sum;

        return Math.max(max_sum, total - min_sum);
    }
}
