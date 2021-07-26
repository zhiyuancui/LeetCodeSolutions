package solutions;

import util.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * 57 Insert Interval
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || newInterval == null) {
            return new int[0][0];
        }

        int pos = 0;

        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];

            if(cur[1] < newInterval[0]) {
                res.add(cur);
                pos = i + 1;
            } else if(cur[0] > newInterval[1]) {
                res.add(cur);
                continue;
            } else {
                newInterval[0] = Math.min(cur[0], newInterval[0]);
                newInterval[1] = Math.max(cur[1], newInterval[1]);
            }
        }

        res.add(pos, newInterval);

        int[][] result = new int[res.size()][2];

        for(int i = 0; i < result.length; i++) {
            result[i][0] = res.get(i)[0];
            result[i][1] = res.get(i)[1];
        }

        return result;
    }
}
