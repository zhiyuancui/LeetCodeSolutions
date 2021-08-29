package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1383 Maximum Performance of a Team
 * https://leetcode-cn.com/problems/maximum-performance-of-a-team/solution/pai-xu-dui-onlgn-by-henrylee4/
 */
public class MaxPerformanceOfATeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] items = new int[n][2];

        for(int i = 0; i < n; i++) {
            items[i][0] = speed[i];
            items[i][1] = efficiency[i];
        }

        Arrays.sort(items, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        long res = 0;
        long sum = 0;
        int mod = (int)1e9 + 7;

        for(int i = 0; i < n; i++) {
            if(queue.size() > k -1) {
                sum -= queue.poll();
            }

            res = Math.max(res, (sum+items[i][0]) * items[i][1]);

            queue.add(items[i][0]);

            sum += items[i][0];
        }

        return (int)(res % mod);
    }
}
