package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 228 Summary Ranges
 */
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
        
        List<String> result = new ArrayList<String>();
        if( nums == null || nums.length == 0 ){
            return result;
        }
        
        for(int i = 0; i < nums.length; i++){
            String range = Integer.toString( nums[i] );
            boolean isRange = false;
            while( i + 1< nums.length && nums[ i + 1 ] == nums[i] + 1 ){
                i++;
                isRange = true;
            }
            if( isRange ){
                range +="->"+nums[i];
            }
            result.add( range );
        }
        
        return result;
        
    }
}
