package solutions;

public class JumpGame {
	/**
	 * Jump Game
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		if( nums == null || nums.length == 0 ){
            return false;
        }
        
        int furthest = nums[0];
        for(int i =1;i < nums.length; i++){
            
        	if(i > furthest ){
                return false;
            }
            
            furthest = Math.max( furthest, i + nums[i]);
        }
        
        return furthest >= nums.length - 1;
    }
}
