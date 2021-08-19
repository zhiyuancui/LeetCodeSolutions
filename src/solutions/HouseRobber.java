package solutions;

/**
 * 198 House Robber
 */
public class HouseRobber {

	

	public int rob(int[] nums) {
        if( nums == null || nums.length == 0 ){
            return 0;
        }
        
        if( nums.length == 1 ){
            return nums[0];
        }
        
        int[] money = new int[ nums.length ];
        
        money[0] = nums[0];
        money[1] = Math.max( money[0], nums[1]);
        
        for(int i = 2; i < nums.length; i++){
            money[i] = Math.max( money[ i - 1 ], money[ i - 2] + nums[i]);
        }
        
        return money[ nums.length - 1 ];
    }

    public int rob2(int[] nums) {
        if( nums == null || nums.length == 0 ){
            return 0;
        }

        if( nums.length == 1 ){
            return nums[0];
        }

        int curr, prev, prev2;
        curr = prev = prev2 = 0;
        for (int i = 0; i < nums.length; i++) {
            curr = Math.max(prev2 + nums[i], prev);
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }

}
