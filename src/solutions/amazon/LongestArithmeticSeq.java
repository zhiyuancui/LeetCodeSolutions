package solutions.amazon;


import java.util.HashMap;
import java.util.Map;

/**
 * 1027 Longest Arithmetic Subsequence
 */
public class LongestArithmeticSeq {
    public int longestArithSeqLength(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> dp[] = new HashMap[nums.length];

        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
            for(int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int len = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, len);
                max = Math.max(max, len);
            }
        }

        return max;
    }
}
