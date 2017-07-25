package solutions;

public class TargetSum {
	int solution = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if( nums == null || nums.length == 0 ) {
            return 0;
        }
        generate(nums, S, 0);
        return solution;
    }
    
    private void generate(int[]nums, int target, int start) {
        if( start == nums.length ) {
            if( target == 0 ){
                solution++;
            }
            return;
        }
        
        generate(nums, target - nums[start], start+1);
        generate(nums, target + nums[start], start+1);
    }
    
   /** 
    * DP solution 
    * Reference to :https://discuss.leetcode.com/topic/76264/short-java-dp-solution-with-explanation
    * @param nums
    * @param s
    * @return
    */
    public int findTargetSumWays2(int[] nums, int s) {
        int sum = 0; 
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[0+sum] = 1;// where sum value is 0
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum+s];
    }
}
