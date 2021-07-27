package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 163 Nissing Ranges
 */
public class MissingRanges {
	
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<String>();
		int next = lower;
		
		for(int i = 0; i < nums.length; i++){
			if( nums[i] < next ){
				continue;
			}
			
			if( nums[i] == next ){
				next++;
				continue;
			}
			
			result.add(getRange(next, nums[i] - 1));
			
			next = nums[i] + 1;
		}
		
		if( next <= upper ){
			result.add(getRange(next, upper));
		}
		
		return result;
	}
	
	private String getRange(int lower, int upper){
		return ( lower == upper ) ? String.valueOf(lower) : lower+"->"+upper;
	}
}
