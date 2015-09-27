package solutions;

public class MaxSubArray {

	/**
	 * Find the contiguous subarray within an array 
	 * (containing at least one number) which has the largest sum.
	 * @param nums
	 * @return
	 */
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
