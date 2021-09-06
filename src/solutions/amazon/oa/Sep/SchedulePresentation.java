package solutions.amazon.oa.Sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SchedulePresentation {

    public int getMaxPresentation(int[] start, int[] duration) {
        List<int[]> intervals = new ArrayList<>();

        for(int i = 0; i < start.length; i++) {
            intervals.add(new int[]{start[i], start[i]+ duration[i]});
        }

        Collections.sort(intervals, (a,b) -> a[1] - b[1]);

        int res = 0;
        int end = Integer.MIN_VALUE;

        for(int[] interval : intervals) {
            if(interval[0] > end) {
                res++;
                end = interval[1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SchedulePresentation s = new SchedulePresentation();

        System.out.println("Expected: 4");
        int[] start = new int[]{1,10,53,78,140,150};
        int[] duration = new int[]{12,54,12,65,23,68};
        System.out.println("Actual: " + s.getMaxPresentation(start, duration));
        System.out.println("--------------------------------------");
    }
}
