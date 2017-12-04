/**
 * Given an array nums, 
 * write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], 
 * after calling your function, nums should be [1, 3, 12, 0, 0].
 */

package solutions;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {
	     
        if( nums == null || nums.length == 0 )
        {
            return;
        }   
        
        int zero = 0;
        int operation = 0;
        for(int i = 0; i < nums.length; i++ )
        {
           if( nums[i] != 0 )
           {
               if( zero != i )
               {
                   nums[ zero ] = nums[i];
                   nums[i] = 0;
                   operation+=2;
               }
               zero++;
           }
        }
        System.out.println( operation );
    }
	
	/**
	 * less operation but don't care order
	 * [0,1,0,3,12]
	 * [12,1,3,0,0]
	 * @param nums
	 */
	public void moveZeroes2(int[] nums ) {
		 if( nums == null || nums.length == 0 ) {
	            return;
        }
        
        int left = 0;
        int right = nums.length - 1;
        for(; left < nums.length; left++ ) {
            if( left > right ) {
                nums[left] =0;
                continue;
            }
            
            if( nums[left] != 0 ) {
                continue;
            }
            
            while( right >= 0 && nums[right] == 0 ) {
                right--;
            }
            
            if( right >= 0 ) {
                nums[ left ] = nums[ right ];
                right--;
                
            }
        }
	}
}
