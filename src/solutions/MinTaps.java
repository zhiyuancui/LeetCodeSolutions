package solutions;

import java.util.Arrays;

/**
 * 1326 Minimum Number of Taps to Open to Water a Garden
 */
public class MinTaps {
    public int minTaps(int n, int[] ranges) {
        int[] intervals = new int[n+1];

        for(int i = 0; i < ranges.length; i++) {
            if(ranges[i] == 0) continue;
            int left = i - ranges[i] >= 0 ?  i - ranges[i] : 0;
            int right = i + ranges[i];

            intervals[left] = Math.max(intervals[left], right);
        }

        int last = 0;
        int count = 0;
        int max = 0;

        for(int i =0 ; i <= n; i++) {
            if(last < i) {
                count++;
                last = max;
            }

            if(last < i) {
                return -1;
            }

            max = Math.max(max, intervals[i]);
        }

        return count;
    }
}
