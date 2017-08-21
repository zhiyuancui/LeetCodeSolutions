package solutions;

public class MaxProductSubarray {
	/**
	 * Maximum Product Subarray
	 * @param nums
	 * @return
	 */
	public int maxProduct(int[] nums) {
        
        if( nums == null || nums.length == 0 ){
            return 0;
        }
        
        if( nums.length == 1 ){
            return nums[0];
        }
        
        int max = 0;
        int min = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int temp = max;
            max = Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
            min = Math.min(nums[i], Math.min( min * nums[i], temp * nums[i]));
            res = Math.max(res, max);
        }
        
        return res;
    }
}
