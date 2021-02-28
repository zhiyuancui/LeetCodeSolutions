package solutions;

import java.util.HashMap;
import java.util.Map;

public class SubarrayDivisible {
    public int subarraysDivByK(int[] nums, int k) {
        if(nums == null || k == 0) {
            return 0;
        }

        Map<Integer, Integer> presum = new HashMap<>();

        presum.put(0,1);
        int sum = 0;

        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int remainder = sum % k;

            if(remainder < 0) {
                remainder += k;
            }

            if(presum.containsKey(remainder)) {
                count += presum.get(remainder);
            }

            presum.put(remainder, presum.getOrDefault(remainder,0)+1);

        }


        return count;
    }
}
