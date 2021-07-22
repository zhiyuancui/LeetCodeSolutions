package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 325 Maximum Size Subarray Sum Eqauls K
 */
public class MaxSubarraySum {
	public int maxSubArrayLen(int[] nums, int k) {
        if( nums == null || nums.length == 0 ) {
            return 0;
        }
        
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,-1);
        int sum = 0;
        int max = 0;
        for(int i =0; i < nums.length; i++) {
            sum += nums[i];
            if( preSum.containsKey(sum-k) ) {
                max = Math.max(max, i - preSum.get(sum-k) );
            }
            if( !preSum.containsKey(sum) ) {
                preSum.put(sum,i);
            }
        }
            
        return max;

	}
}
