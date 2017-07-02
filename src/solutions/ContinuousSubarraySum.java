package solutions;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
       int runningSum = 0;
       for (int i=0;i<nums.length;i++) {
           runningSum += nums[i];
           if (k != 0) runningSum %= k; 
           Integer prev = map.get(runningSum);
           if (prev != null) {
               if (i - prev > 1) return true;
           }
           else map.put(runningSum, i);
       }
       return false;
   }
}
