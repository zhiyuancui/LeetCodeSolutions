package solutions;

import java.util.Arrays;

public class ThreeSumClosest {
	
	public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2]; 
    	//Do not use Integer.MAX_VALUE in case of overflow
        
        if (nums == null || nums.length < 3) {
			return Integer.MAX_VALUE;
		}
        
        //sort the array
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++)
        {
            int start = i+1;
            int end = nums.length - 1;
            
            while( start < end)
            {
            	int sum = nums[ i ] + nums[start] + nums[end];
                
                if( sum == target )
                {
                    return sum;
                }
                else if( sum < target)
                {
                    start++;
                }
                else
                {
                    end--;
                }
                
                
                closest = Math.abs( sum - target) < Math.abs( closest - target) 
                		? sum : closest;
            }
            
            
        }
    
        return closest;
    }
}
