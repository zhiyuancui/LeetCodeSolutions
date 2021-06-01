package solutions;

import java.util.Arrays;

public class ReversePairs {

	/**
	 * Reference to :
	 * https://discuss.leetcode.com/topic/79227/general-principles-behind-problems-similar-to-reverse-pairs/2
	 * @param nums
	 * @return
	 */
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }

        return sort(nums, 0, nums.length - 1);
    }

    private int sort(int[] nums, int left, int right) {
        if(left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        return sort(nums, left, mid) +
                sort(nums, mid + 1, right) + merge(nums, left, mid, right);
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int res = 0;
        int i = 0;

        while(p1 <= mid && p2 <= right) {
            if(nums[p1] > 2* (long)nums[p2]) {
                res += mid - p1 + 1;
                p2++;
            } else {
                p1++;
            }
        }

        Arrays.sort(nums, left, right+1);

        return res;
    }
}
