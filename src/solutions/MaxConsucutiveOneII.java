package solutions;

/**
 * 487 Max Consecutive Ones II
 */
public class MaxConsucutiveOneII {
    public int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0, zero = 0, k = 1; // flip at most k zero
        for (int left = 0, high = 0; high < nums.length; high++) {
            if (nums[high] == 0)   {
                zero++;
            }
            while (zero > k) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            max = Math.max(max, high - left + 1);
        }
        return max;
    }
}
