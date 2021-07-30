package solutions;

import java.util.Arrays;

/**
 * 1498 Number of Subsequences That Satisfy the Given Sum Condition
 */
public class NumberOfSubThatSatisfy {
    public int numSubseq(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        if(nums[0] * 2 > target) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        long result = 0;

        while(left <= right) {
            if( nums[left] + nums[right] <= target) {
                result += Math.pow(2, (right - left));
                left++;
            } else {
                right--;
            }
        }

        return (int)(result % 1000000007);
    }
}
