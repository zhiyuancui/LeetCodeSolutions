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
    
    
    /**
     * Insert Interval
     * @param intervals
     * @param newInterval
     * @return
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if( newInterval == null || intervals == null ){
            return intervals;
        }
        
        List<Interval> result = new ArrayList<Interval>();
        int insertPos = 0;
        
        for(Interval interval : intervals){
            if( interval.end < newInterval.start ){
                result.add( interval );
                insertPos++;
            }else if( interval.start > newInterval.end ){
                result.add( interval );
            }else{
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        
        result.add( insertPos, newInterval );
        
        return result;
    }
}
