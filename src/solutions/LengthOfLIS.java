package solutions;

import java.util.Arrays;

/**
 * 300 Longest Increasing Subsequence
 */
public class LengthOfLIS {
    /**
     * DP solution
     */
    public int lengthOfLIS2(int[] nums) {
    	if( nums == null || nums.length == 0 ) {
            return 0;
        }
        
        int[] dp = new int[ nums.length ];
        int maxLen  = 1;
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = i-1; j >= 0 ; j--) {
                if( nums[j] < nums[i] ) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
   
    /**
     * Binary Search O( nlogn)
     * @param nums
     * @return
     */
    public int lengthOfLIS3(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
    
}
