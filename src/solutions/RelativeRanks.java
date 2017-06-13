package solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class RelativeRanks {
	public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer, Integer> numIdxMapping = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            numIdxMapping.put(nums[i],i);
        }

        
        nums = Arrays.stream(nums).boxed().sorted( (a,b)->b.compareTo(a) ).mapToInt(i->i).toArray();
        
        String[] result = new String[ nums.length ];
        for(int i = 0; i < nums.length; i++ ){
            int index = numIdxMapping.get( nums[i] );
            if( i == 0 ){
                result[index] = "Gold Medal";
            } else if( i ==  1 ){
                result[index] = "Silver Medal";
            } else if( i == 2 ){
                result[index] = "Bronze Medal";
            } else{
                result[index] = (i+1) + "";
            }
        }
        
        return result;
    }
}
