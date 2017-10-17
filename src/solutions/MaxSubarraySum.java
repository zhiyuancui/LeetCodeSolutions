package solutions;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarraySum {
	public int maxSubArrayLen(int[] nums, int k) {
        if( nums == null || nums.length == 0 ) {
            return 0;
        }
        
        Map<Integer, Integer> preSum = new HashMap<>();
        
        int sum = 0;
        int max = 0;
        for(int i =0; i < nums.length; i++) {
            sum += nums[i];
            if( sum == k ) {
                max = i + 1;
            }
            if( preSum.containsKey(sum-k) ) {
                max = Math.max(max, i - preSum.get(sum-k) );
            }
          //because the duplicate will narrow the range and you are looking for maximum length.
            //[1,-1,5,-2,3], 3
            if( !preSum.containsKey(sum) ) {
                preSum.put(sum,i);
            }
        }
        
        return max;
    }
}
