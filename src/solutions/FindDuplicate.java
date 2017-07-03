package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find Duplicate Number
 * @author Zhiyuan
 *
 */
public class FindDuplicate {
	public int findDuplicate(int[] nums) {
		if( nums == null || nums.length == 0 )
        {
            return 0;
        }
        
        int low = 0;
        int high = nums.length - 1;
        int mid = ( high + low ) / 2;
        
        while( high - low > 1){
            int count = 0;
            for(int i : nums)
            {
                if( i > mid && i <= high ){
                    count++;
                }
            }
            if( count > high - mid ){
                low = mid;
            }
            else{
                high = mid;
            }
            mid = ( high + low ) / 2;
        }
        
        return high;
    }
	
	public int findDuplicate2(int[] nums) {
		if( nums == null || nums.length <=1 )
        {
            return 0;
        }
        
        int slow = nums[0];
        int fast = nums[ nums[0] ];
        
        while( slow != fast ){
        	slow = nums[ slow ];
        	fast = nums[ nums[fast] ];
        }
        
        fast = 0;
        while( fast != slow ){
        	fast = nums[ fast ];
        	slow = nums[ slow ];
        }
        
        return slow;
    }
	
	
	/**
	 * Find All Duplicates in an Array
	 * @param nums
	 * @return
	 */
	public List<Integer> findDuplicates4(int[] nums) {
	     List<Integer> result = new ArrayList<Integer>();
	     
	     for(int i = 0; i < nums.length; i++) {
	    	 int index = Math.abs(nums[i]) - 1;
	    	 if( nums[index] < 0 ){
	    		 result.add(index+1);
	    	 }
	    	 nums[index] = -nums[index];
	     }
	     
	     return result;
		
		
	}
	    
	
}
