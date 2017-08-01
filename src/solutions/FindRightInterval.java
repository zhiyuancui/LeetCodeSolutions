package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Interval;

public class FindRightInterval {
	/**
	 * Reference to: http://www.cnblogs.com/grandyang/p/6810361.html
	 * @param intervals
	 * @return
	 */
	public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        List<Integer> value = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
            value.add( intervals[i].start );
        }
        
        Collections.sort(value, (a,b) -> b-a );
        
        for(int i = 0; i < intervals.length; i++) {
            Interval cur = intervals[i];
            int j = 0;
            for(; j < value.size(); j++) {
                if( value.get(j) < cur.end ) break;
            }
            
            result[i] = j > 0 ? map.get( value.get(j-1)) : -1;
        }
        
        return result;
    }
}
