package solutions;

/**
 * 795 Number of Subarrays with Bounded Maximum
 * //https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/discuss/1278743/C%2B%2BJavaPython-Easy-to-understand-solution-Clean-and-Concise-O(N)
 */
public class NumberSubarrayBounded {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left -1);
    }

    private int count(int[] nums, int bound) {
        int ans = 0, count = 0;

        for(int x : nums) {
            count = x <= bound ? count+1 : 0;
            ans += count;
        }

        return ans;
    }
}
