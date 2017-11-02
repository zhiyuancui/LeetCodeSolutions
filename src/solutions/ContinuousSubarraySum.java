package solutions;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		if( nums == null || nums.length == 0 ) {
            return false;
        }
        
        Map<Integer, Integer> presum = new HashMap<>();
        presum.put(0,-1);
        
        int remain = 0;
        for(int i = 0; i < nums.length; i++){
            remain += nums[i];
            if( k != 0 ) {
                remain = remain % k;
            }
            if( presum.containsKey(remain) ) {
                if( i - presum.get(remain) > 1 ) {
                    return true;
                }
            } else {
                presum.put( remain, i);
            }
        }
        
        return false;
   }
}
