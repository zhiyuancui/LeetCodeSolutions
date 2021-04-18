package solutions;

import java.util.Arrays;

public class MinTaps {
    public int minTaps(int n, int[] ranges) {
        int[] intervals = new int[n];

        Arrays.fill(intervals, -1);

        for(int i = 0; i < ranges.length; i++) {
            if(ranges[i] == 0) continue;
            int left = i - ranges[i] >= 0 ?  i - ranges[i] : 0;
            int right = i + ranges[i];

            intervals[left] = Math.max(intervals[left], right);
        }

        if(intervals[0] == -1) {
            return -1;
        }


        int longest = intervals[0];
        int count = 1;
        int i = 0;

        while(longest < n) {
            int temp = Integer.MIN_VALUE;
            for(; i <= longest; i++) {
                int val = intervals[i];
                if(val == -1) {
                    continue;
                }
                temp = Math.max(temp, val);
            }
            if(temp <= longest) {
                return -1;
            }
            longest = temp;
            count++;
        }

        return count;
    }

    //Jump Game II 变种解法
    public int minTaps2(int n, int[] ranges) {
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
