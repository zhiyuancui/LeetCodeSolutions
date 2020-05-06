package solutions;

import util.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
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
