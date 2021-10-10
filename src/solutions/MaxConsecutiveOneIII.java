package solutions;

/**
 * 1004 Max Consecutive Ones III
 */
public class MaxConsecutiveOneIII {
    public int longestOnes(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right;

        for(right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                k--;
            }

            if(k < 0) {
                if(nums[left] == 0) {
                    k++;
                }
                left++;
            }
        }

        return right - left;
    }
}
