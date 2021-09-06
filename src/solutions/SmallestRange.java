package solutions;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 632 Smallest Rnage Covering Elements from K lists
 */
public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        if(nums == null || nums.size() == 0) {
            return new int[]{};
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int max = nums.get(0).get(0);
        for(int i = 0; i < nums.size(); i++) {
            minHeap.add(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }

        int minRange = Integer.MAX_VALUE;
        int start = -1;

        while(minHeap.size() == nums.size()) {
            int[] cur = minHeap.poll();
            if(max - cur[0] < minRange) {
                minRange = max - cur[0];
                start = cur[0];
            }

            if(cur[2] + 1 < nums.get(cur[1]).size()) {
                cur[0] = nums.get(cur[1]).get(cur[2]+1);
                cur[2]++;
                minHeap.add(cur);
                max = Math.max(max, cur[0]);
            }
        }

        return new int[]{start, start+ minRange};
    }
}
