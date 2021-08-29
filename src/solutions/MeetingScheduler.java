package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1229 Meeting Scheduler
 */
public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a,b) -> a[0] - b[0]);

        int idx1 = 0;
        int idx2 = 0;

        while(idx1 < slots1.length && idx2 < slots2.length) {
            int start = Math.max(slots1[idx1][0], slots2[idx2][0]);
            int end = Math.min(slots1[idx1][1], slots2[idx2][1]);

            if(end - start >= duration) {
                return Arrays.asList(start, start+duration);
            }

            if(slots1[idx1][1] < slots2[idx2][1]) {
                idx1++;
            } else {
                idx2++;
            }
        }

        return new ArrayList<>();
    }

    /**
     * 更快的解法
     */
    public List<Integer> minAvailableDuration2(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int[] slot : slots1) {
            if (slot[1] - slot[0] >= duration) {
                minHeap.offer (slot);
            }
        }

        for (int[] slot : slots2) {
            if (slot[1] - slot[0] >= duration) {
                minHeap.offer (slot);
            }
        }

        while (minHeap.size () >= 2) {
            int[] slot = minHeap.poll ();
            int[] currSlot = minHeap.peek ();
            if (slot[1] - currSlot[0] >= duration) {
                return new ArrayList<> (Arrays.asList (currSlot[0], currSlot[0] + duration));
            }
        }

        return new ArrayList<> ();
    }
}
