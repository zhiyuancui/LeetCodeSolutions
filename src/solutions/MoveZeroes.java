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
	
	public void moveZeroes2(int[] nums ) {
		 int right = nums.length-1;
         int operations=0;
         for(int left = 0; left < nums.length; left++){
	         if(left>right){
	             nums[left]=0;
	             operations++;
	             continue;
	         }                 
	         if(nums[left] != 0){
	                 continue;
	         }
	         while (nums[right] == 0) right--;
	         nums[left]=nums[right];
	         operations++;
	         right--;
		 }
         System.out.println("Method 2 Operation Times: " + operations);
	}
}
