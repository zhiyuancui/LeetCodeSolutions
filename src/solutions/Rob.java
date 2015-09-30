package solutions;

public class Rob {

	
	/**
	 * House Robber
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
        
        if( nums == null || nums.length == 0 )
        {
            return 0;
        }
        
        if( nums.length == 1 )
        {
            return nums[0];
        }
        
        
        int[] money = new int[ nums.length ];
        money[0] = nums[0];
        money[1] = Math.max(money[0], nums[1]);
        
        for(int i = 2; i < nums.length; i++ )
        {
            money[i] = Math.max( money[ i - 1], nums[i] + money[i-2]);
        }
        
        return money[ nums.length - 1 ];
    }
	
}
