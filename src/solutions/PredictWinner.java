package solutions;

public class PredictWinner {
	public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int i =0; i < n; i++){
            dp[i][i] = nums[i];
        }
        
        for(int len = 1; len < n; len++) {
            for( int i = 0; i < n- len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        
        return dp[0][n-1] >= 0;
    }
}
