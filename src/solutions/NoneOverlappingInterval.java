package solutions;

import java.util.Arrays;
import java.util.Comparator;

import util.Interval;

/**
 * 435 Non-overlapping Intervals
 */
public class NoneOverlappingInterval {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null) {
            return 0;
        }

        Arrays.sort(intervals, (a,b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        int count = 0;

        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(prev[1] > intervals[i][0]) {
                if(prev[1] > intervals[i][1]) {
                    prev = intervals[i];
                }
                count++;
            } else {
                prev = intervals[i];
            }
        }

        return count;
    }
}