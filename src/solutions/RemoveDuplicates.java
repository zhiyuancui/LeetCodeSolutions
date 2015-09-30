package solutions;

public class RemoveDuplicates {
	
	/**
	 * Given a sorted array, 
	 * remove the duplicates in place such that 
	 * each element appear only once and return the new length.
	 * Do not allocate extra space for another array, 
	 * you must do this in place with constant memory.
	 * For example,Given input array nums = [1,1,2],
	 * Your function should return length = 2, 
	 * with the first two elements of nums being 1 and 2 respectively. 
	 * It doesn't matter what you leave beyond the new length.
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
        
        if( nums == null || nums.length < 2 )
        {
            return nums.length;
        }
        
        int index = 0;
        for(int i = 1; i < nums.length; i++)
        {
            if( nums[i] != nums[index] )
            {
                index++;
                nums[index] = nums[i];
            }
            
        }
        
        return index;
    }
	
	/**
	 * 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates2(int[] nums) {
        if( nums == null || nums.length <= 2 )
        {
            return nums.length;
        }
        
        int len = 2;
        int pos = 2;
        
        while( pos < nums.length )
        {
            if( nums[ len - 2] != nums[pos] )
            {
                nums[ len ] = nums[pos];
                len++;
            }
            pos++;
        }
        
        return len;
    }
}
