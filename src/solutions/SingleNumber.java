package solutions;

/**
 * 
 * @author Zhiyuan
 *
 */

public class SingleNumber {
	
	/**
	 * Given an array of integers, 
	 * every element appears twice except for one. 
	 * Find that single one.
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
	     
        if( nums == null || nums.length == 0 )
        {
            return 0;
        }   
        
        int single = 0;
        for( int i : nums )
        {
            single ^= i;
        }
        
        return single;
    }
}
