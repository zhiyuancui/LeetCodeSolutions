package solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestSumOfMatrix {
    public int kthSmallest(int[][] mat, int k) {

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);

        maxHeap.offer(0);

        for(int[] row: mat) {
            Queue<Integer> curHeap = new PriorityQueue<>((a,b) -> b-a);

            for(int preSum: maxHeap) {
                for(int i = 0;i < Math.min(row.length, k); i++) {
                    curHeap.offer(preSum + row[i]);
                    if(curHeap.size() > k) {
                        curHeap.poll();
                    }
                }
            }
            maxHeap = curHeap;
        }


        return maxHeap.poll();
    }
}
