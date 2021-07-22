package solutions;

import java.util.*;

import util.Interval;

/**
 * 56 Merge Intervals
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        if(intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] prev = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if(cur[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], cur[1]);
            } else {
                result.add(prev);
                prev = cur;
            }
        }

        result.add(prev);

        int[][] res = new int[result.size()][2];

        for(int i = 0; i < result.size(); i++) {
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }

        return res;
    }
}
