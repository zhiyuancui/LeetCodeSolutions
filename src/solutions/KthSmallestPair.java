package solutions;

import java.util.Arrays;

public class KthSmallestPair {
    // https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance/solution/java-er-fen-cha-zhao-fang-fa-zhu-xing-zh-oniz/
    public int smallestDistancePair(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int min = 0;
        int max = nums[nums.length - 1] - nums[0];


        while(min < max) {
            int mid = min + (max-min) / 2;

            int left = 0,count = 0;
            for(int right = 0; right < nums.length; right++) {
                while(nums[right] - nums[left] > mid) {
                    left++;
                }
                count += right - left;
            }

            if(count >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

        return min;
    }
}
