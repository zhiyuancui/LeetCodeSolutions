package solutions;

public class SearchInRotatedArray {
	
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
	
	/**
	 * No duplicates
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search2(int[] nums, int target) {
	     
	     if( nums == null || nums.length == 0 )
	     {
	         return -1;
	     }  
	     
	     int start = 0;
	     int end = nums.length - 1;
	     
	     while( start < end )
	     {
	         int mid = start + ( (end - start) >> 1);
	         if( target == nums[mid] )
	         {
	             return mid;
	         }
	         else if( nums[start] <= nums[mid] )
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
	         else
	         {
	             if( nums[mid] < target && target <= nums[end] )
	             {
	                start = mid + 1;
	             }
	             else
	             {
	                 end = mid - 1;
	             }
	         }
	         
	     }
	     
	     if( nums[ start ] == target )
	     {
	         return start;
	     }
	     
	     return -1;
	    }
	
}
