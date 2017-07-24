package solutions;

public class PredictWinner {
	public boolean PredictTheWinner(int[] nums) {
		int n = nums.length;
        int[][] dp = new int[n][n];
        
        for(int i =0; i < n; i++){
            dp[i][i] = nums[i];
        }
        
        for(int i = 1; i <nums.length;i++) {
            for( int j = 0; i+j<nums.length; j++) {
                dp[j][i+j] = Math.max(nums[j] - dp[j+1][i+j], nums[i+j] - dp[j][i+j-1]);
            }
        }
        
        return dp[0][n-1] >= 0;
    }
}
