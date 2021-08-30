package solutions;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
	
	/**
	 * Majority Element
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
        
        if( nums == null || nums.length == 0 )
        {
            return 0;
        }
        
        int count = 0;
        int majority = 0;
        
        for(int i : nums )
        {
            if( count == 0 )
            {
                majority = i;
            }
            
            if( majority == i )
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        
        return majority;
    }
}
