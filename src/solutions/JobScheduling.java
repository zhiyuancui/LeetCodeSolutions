package solutions;

import java.util.Arrays;

/**
 * 1235 Maximum Profit in Job Scheduling
 */
public class JobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] arr = new int[n][3];

        for(int i = 0; i < n; i++) {
            arr[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(arr, (x, y) -> x[1] - y[1]);

        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            int pre = binarySearch(arr, i);
            dp[i] = Math.max(i > 0 ? dp[i-1] : 0, (pre >= 0 ? dp[pre] : 0) + arr[i][2]);
        }

        return dp[n-1];
    }

    private int binarySearch(int[][] arr, int i) {
        int left = 0, right = i - 1;

        while(left < right) {
            int mid = (left+right+1)/ 2;

            if(arr[mid][1] <= arr[i][0]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        if(left < i && arr[left][1] <= arr[i][0]) {
            return left;
        }

        return -1;
    }
}
