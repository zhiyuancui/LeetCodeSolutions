package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarray {
    public int shortestSubarray(int[] A, int k) {
        if(A == null || A.length == 0) {
            return 0;
        }

        int[] prefixSum = new int[A.length+1];
        prefixSum[0] = 0;

        int min = Integer.MAX_VALUE;

        for(int i = 1; i < A.length+1; i++) {
            prefixSum[i] = A[i-1] + prefixSum[i-1];
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < A.length+1; i++) {
            while(!deque.isEmpty() && prefixSum[i]-prefixSum[deque.peekFirst()] >= k) {
                min = Math.min(min, i - deque.peekFirst());
                deque.pollFirst();
            }

            while(!deque.isEmpty() && prefixSum[i] < prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offer(i);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
