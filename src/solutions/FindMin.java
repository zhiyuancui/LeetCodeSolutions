package solutions;

public class FindMin {
	
	
	/**
	 * Without duplicates
	 * @param nums
	 * @return
	 */
	public int findMin(int[] nums) {
        
        if( nums == null || nums.length == 0 )
        {
            return 0;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while( start < end )
        {
            int mid = start + ( end - start ) / 2;
            if(nums[start] < nums[ end ] )
            {
                return nums[start];
            }
            
            if( nums[ end ] < nums[mid] )
            {
                start = mid + 1;
            }
            else
            {
                end = mid;
            }
            
        }
        
        return nums[start];
    }
}
