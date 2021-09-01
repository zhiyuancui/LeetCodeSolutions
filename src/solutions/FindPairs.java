package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 532 K-diff Pairs in an Array
 */
public class FindPairs {
	public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }

    public int findPairs2(int[] nums, int k) {
        if (k < 0) return 0;
        Arrays.sort(nums);
        int ans = 0;

        for(int i = 0, j = 1; j < nums.length;){
            if(i == j || nums[i] + k > nums[j]){
                j++;
            }
            else if(i > 0 && nums[i] == nums[i - 1] || nums[i] + k < nums[j]){
                i++;
            }
            else{
                ans++;
                i++;
            }

        }
        return ans;
    }
}
