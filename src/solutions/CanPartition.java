package solutions;

public class CanPartition {
	public boolean canPartition(int[] nums) {
        if( nums == null || nums.length == 0) {
            return false;
        }
        
        if( nums.length == 1 ) {
            return false;
        }
        
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        
        volumn /= 2;
        
        boolean[] dp = new boolean[volumn+1];
        dp[0] = true;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = volumn; j >= nums[i]; j--){
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[volumn];
    }
}
