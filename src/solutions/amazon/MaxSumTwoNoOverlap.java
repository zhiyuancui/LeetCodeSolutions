package solutions.amazon;

/**
 * 1031 Maximum Sum of Two Non-Overlapping Subarrays
 */
public class MaxSumTwoNoOverlap {

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] sums = new int[nums.length];
        sums[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }

        int maxFirst = sums[firstLen - 1];
        int maxSecond = sums[secondLen - 1];

        int max = sums[firstLen + secondLen - 1];

        for(int i = firstLen + secondLen; i < nums.length; i++) {
            maxFirst = Math.max(maxFirst, sums[i-secondLen] - sums[i-firstLen-secondLen]);
            maxSecond = Math.max(maxSecond, sums[i-firstLen] - sums[i-firstLen-secondLen]);

            max = Math.max(max, maxFirst + sums[i] - sums[i-secondLen]);
            max = Math.max(max, maxSecond + sums[i] - sums[i-firstLen]);
        }

        return max;
    }
}
