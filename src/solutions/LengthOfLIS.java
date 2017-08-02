package solutions;

import java.util.Arrays;

public class LengthOfLIS {
	public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            int pos = binarySearch(dp,len,nums[i]);
            if (nums[i] < dp[pos]) dp[pos] = nums[i];
            if (pos > len) {
                len = pos;
                dp[len] = nums[i];
            }
        }
        return len+1;
    }
    private int binarySearch(int[] dp, int len, int val) {
        int left = 0;
        int right = len;
        while(left+1 < right) {
            int mid = left + (right-left)/2;
            if (dp[mid] == val) {
                return mid;
            } else {
                if (dp[mid] < val) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (dp[right] < val) return len+1;
        else if (dp[left] >= val) return left;
        else return right;
    }
    
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
   
}
