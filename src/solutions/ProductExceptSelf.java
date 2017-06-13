/**
 * Given an array of n integers where n > 1, nums, 
 * return an array output such that 
 * output[i] is equal to the product of all the elements 
 * of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 */
package solutions;

public class ProductExceptSelf {
	
	public int[] productExceptSelf(int[] nums) {
        
        int[] result = new int[ nums.length ];
        
        if( nums == null || nums.length == 0 )
        {
            return result;
        }
        
        int[] left = new int[ nums.length ];
        int[] right = new int[ nums.length ];
        
        left[0] = 1;
        for(int i = 1; i <  nums.length; i++)
        {
            left[i] = left[ i - 1 ]*nums[ i - 1 ];
        }
        
        right[ nums.length -1 ] = 1;
        
        for(int i = nums.length - 2; i>=0; i--)
        {
            right[i] = right[ i + 1 ] * nums[ i + 1 ];
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            result[i] = left[i] * right[ i ];
        }
        
        return result;
             
    }
	
	/**
	 * Concise Solution
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf2(int[] nums) {
        if( nums == null || nums.length < 2 )
        {
            return nums;
        }
        
        int[] result = new int[nums.length];
        int l = 1;
        int r = 1;
        for(int j = 0;j<result.length;j++) {
            result[j] = 1;
        }
        for(int i = 0;i<nums.length-1;i++) {
            l *= nums[i];
            int rIndex = nums.length - i - 1;
            r *= nums[rIndex];
            result[i+1] *= l;
            result[rIndex -1] *= r;
        }

        return result;
    }
}
