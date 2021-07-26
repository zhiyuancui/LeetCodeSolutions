package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 1060 Missing Element in Sorted Array
 */
public class MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        if(k > nums[end] - nums[0] - end) {
            return nums[end] + k - (nums[end] - nums[0] - end);
        }

        while(start != end) {
            int mid = start + (end - start) / 2;
            int missingCount = nums[mid] - nums[0] - mid;

            if(missingCount < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        int missingCount = nums[start -1] - nums[0] - start + 1;
        return nums[start - 1] + k - missingCount;
    }

    public int missingElement2(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        for(int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i-1] -1;
            if(diff < k) {
                k -= diff;
            } else {
                return nums[i-1] + k;
            }
        }

        return nums[nums.length - 1] + k;
    }
}
