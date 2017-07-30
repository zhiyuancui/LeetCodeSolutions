package solutions;

import java.util.Arrays;

public class RussianDollEnvelopes {
	
	/**
	 * Reference to :https://discuss.leetcode.com/topic/47469/java-nlogn-solution-with-explanation
	 * After sort, find longest increasing sequence
	 * @param envelopes
	 * @return
	 */
	public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 
       || envelopes[0] == null || envelopes[0].length != 2){
            return 0;
       }
        
        Arrays.sort(envelopes, (a,b) -> {
            if( a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if(index == len){
                len++;
            }
        }
        return len;
    }
	
	/**
	 * DP Solution
	 * @param envelopes
	 * @return
	 */
	public int maxEnvelopes2(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 
       || envelopes[0] == null || envelopes[0].length != 2){
            return 0;
       }
        
        Arrays.sort(envelopes, (a,b) -> {
            if( a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        
        int   n  = envelopes.length;
        int[] dp = new int[n];

        int ret = 0;
        for (int i = 0; i < n; i++){
            dp[i] = 1;

            for (int j = 0; j < i; j++){
                if (   envelopes[i][0] > envelopes[j][0]
                    && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);    
                }
            }

            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
