package solutions.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MeetScheduler {
    private static List<Integer> minAvailableDuration2(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);     // min heap
        for (int[] slot : slots1) {
            if (slot[1] - slot[0] >= duration) {
                queue.offer(slot);
            }
        }
        for (int[] slot : slots2) {
            if (slot[1] - slot[0] >= duration) {
                queue.offer(slot);
            }
        }

        int[] prev = queue.poll();
        while (!queue.isEmpty()) {   // keep comparing current and prev slots till we encounter the slots that matches the given duration
            int[] current = queue.poll();
            if (current[0] + duration <= prev[1]) {    // this is because the queue is sorted by start times. so compare the current + duration with prev (as curr[0] ALWAYS >= prev[0])
                result.add(current[0]);
                result.add(current[0] + duration);
                break;   // break the loop when we encounter the given condition
            }
            prev = current;
        }
        return result;
    }
}
