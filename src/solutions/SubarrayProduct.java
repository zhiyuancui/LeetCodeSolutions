package solutions;

/**
 * 713 Subarray Product Less Than K
 */
public class SubarrayProduct {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) {
            return 0;
        }

        int prod = 1, result = 0, left = 0;

        for(int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while(prod >= k) {
                prod /= nums[left];
                left++;
            }
            result += right - left + 1;
        }

        return result;
    }
}
