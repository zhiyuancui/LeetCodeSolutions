package solutions;

public class MinSubArray {
	/**
	 * Minimum Size Subarray Sum
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen(int s, int[] nums) {
        if( nums == null || nums.length == 0 || s<= 0 ){
            return 0;
        }
        
        int left = 0;
        int right = 0;
        
        int len = Integer.MAX_VALUE;
        int sum =0;
        
        for(left = 0; left < nums.length; left++){
            while( right < nums.length && sum < s){
                sum += nums[ right ];
                right++;
            }
            
            if( sum >= s ){
                len = Math.min(len, right - left );
            }
            sum -= nums[left];
        }
        
        if( len == Integer.MAX_VALUE ){
            len = 0;
        }
        
        return len;
        
    }
}
