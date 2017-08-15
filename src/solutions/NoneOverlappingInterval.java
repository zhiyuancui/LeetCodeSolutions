package solutions;

import java.util.Arrays;
import java.util.Comparator;

import util.Interval;

public class NoneOverlappingInterval {

	public int eraseOverlapIntervals(Interval[] intervals) {
        if( intervals == null || intervals.length == 0 ) {
            return 0;
        }
        
       Arrays.sort(intervals, new IntervalComparator() );
        
        
        int count = 0;
        int end = intervals[0].end;
        
        for(int i = 1; i < intervals.length; i++) {
            if( intervals[i].start < end ) {
                count++;
            } else {
                end = intervals[i].end;
            }
        }
        
        return count;
    }
    
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
}