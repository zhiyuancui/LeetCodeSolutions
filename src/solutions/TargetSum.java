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
}
