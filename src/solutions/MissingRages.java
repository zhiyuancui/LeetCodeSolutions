package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, 
 * return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
 * return ["2", "4->49", "51->74", "76->99"].
 * 
 * Reference to : https://leetcode.com/discuss/45508/accepted-java-solution-with-explanation
 * 
 * @author Zhiyuan
 *
 */
public class MissingRages {
	
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
