package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import util.Interval;

public class Intervals {

	/**
	 * Merge Intervals
	 * @param intervals
	 * @return
	 */
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if( intervals == null || intervals.size() == 0 ){
            return result;
        }
        
        Collections.sort(intervals, (a,b) -> {
        	return a.start - b.start;
        } );
        Iterator<Interval> it = intervals.iterator();
        Interval last = it.next();
        while( it.hasNext() ){
            Interval cur = it.next();
            if( cur.start <= last.end ){
                last.end = Math.max( last.end, cur.end );
            }else{
                result.add( last );
                last = cur;
            }
        }
        
        result.add( last );
        return result;
    }
}
