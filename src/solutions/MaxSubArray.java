package solutions;

/**
 * 53 Maximum Subarray
 */
public class MaxSubArray {

	public int maxSubArray(int[] nums) {
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i : nums)
        {
             sum += i;
             max = Math.max(max, sum);
             sum = Math.max(sum, 0);
        }
        
        return max;
    }
}
