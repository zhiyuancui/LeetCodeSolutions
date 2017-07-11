package solutions;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {
	public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(nums.size(), new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = nums.get(0).get(0);
        for(int i=0; i<nums.size(); i++) {
            minHeap.add(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }

        int minRange = Integer.MAX_VALUE;
        int start = -1;
        while(minHeap.size() == nums.size()) {
            int[] t = minHeap.poll();
            if(max - t[0] < minRange) {
                minRange = max - t[0];
                start = t[0];
            }

            if(t[2]+1 < nums.get(t[1]).size()) {
                t[0] = nums.get(t[1]).get(t[2]+1);
                t[2] ++;
                minHeap.add(t);
                max = Math.max(max, t[0]);
            }
        }

        return new int[]{start, start+minRange};
    }
}
