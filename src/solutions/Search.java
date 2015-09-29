package solutions;

public class Search {
	
	/**
	 * With Duplicates
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean search(int[] nums, int target) {
	     
	     
        if( nums == null || nums.length == 0 )
        {
            return false;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while( start < end )
        {
            int mid = start + ( ( end - start ) >> 1 );
            if( nums[mid]  == target )
            {
                return true;
            }
            
            if( nums[start] < nums[mid] )
            {
                if( nums[start] <= target && target <= nums[mid] )
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
            else if( nums[ start ] > nums[ mid ] )
            {
                if( nums[mid] <= target && target <= nums[ end ] )
                {
                    start = mid+1;
                }
                else
                {
                    end = mid - 1;
                }
            }
            else
            {
                start++;
            }
            
        }
        
        if( nums[start] == target )
        {
            return true;
        }
        else{
            return false;
        }
    }
}
