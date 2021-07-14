package solutions;

import java.util.Arrays;

/**
 * 1296. Divide Array in Sets of K Consecutive Numbers
 */
public class DivideArrayIntoSetOfK {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return true;
        }

        Arrays.sort(nums);

        int[] buckets = new int[k];

        for(int i = 0; i < nums.length; i++) {
            if(i % k != 0 && nums[i] - nums[i-1] > 1) {
                return false;
            }

            buckets[nums[i] % k]++;
        }

        for(int bucket : buckets) {
            if(bucket != buckets[0]) {
                return false;
            }
        }

        return true;
    }
}
