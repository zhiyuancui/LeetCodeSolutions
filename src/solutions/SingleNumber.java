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
	
	
	/**
	 * Given an array of integers, 
	 * every element appears three times except for one. 
	 * Find that single one.
	 * @param nums
	 * @return
	 */
	public int singleNumber2(int[] nums) {
        int[] num = new int[32];
        
        for( int i = 0 ; i < 32; i++ )
        {
            for( int n : nums )
            {
                int digit = n >> i & 1;
                num[i] += digit;
            }
            
            num[i] = num[i] % 3;
        }
        
        int result = 0;
        for( int i = 0 ; i < 32; i++ )
        {
            result |= num[i] << i; 
        }
        
        return result;
    }
}
