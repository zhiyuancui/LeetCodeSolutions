package solutions;

public class RemoveDuplicates {

    /**
     * 26. Remove Duplicates from Sorted Array
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
        
        return index+1;
    }
}
