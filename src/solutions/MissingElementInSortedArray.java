package solutions;

import java.util.HashSet;
import java.util.Set;

public class MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int left = nums[0];
        int right = nums[nums.length -1];

        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }

        int count = 0;

        for(int i = left; i<= right; i++) {
            if(!set.contains(i)) {
                count++;
            }

            if(count == k) {
                return i;
            }
        }

        return right + k - count;
    }
}
