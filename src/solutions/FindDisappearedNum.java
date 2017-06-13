package solutions;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNum {
	
	/**
	 * Reference to: https://discuss.leetcode.com/topic/65738/java-accepted-simple-solution
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        if ( nums.length < 2 ){
            return result;    
        }
        
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs( nums[i] ) - 1;
            if( nums[index] > 0 ){
                nums[ index ] = -nums[index];
            }
            
        }
        
        for(int i = 0; i < nums.length; i++) {
            if( nums[i] > 0 ) {
                result.add( i + 1 );
            }
        }
        
        return result;
    }
}
