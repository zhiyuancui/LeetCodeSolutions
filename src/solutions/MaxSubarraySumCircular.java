package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }

        int[] nums = new int[A.length * 2 +1];

        for(int i = 0; i < 2*A.length; i++) {
            nums[i+1] = nums[i] + A[i%A.length];
        }

        int ans = A[0];
        Deque<Integer> deque = new ArrayDeque();
        deque.offer(0);

        for(int i = 1; i <= 2*A.length; i++) {
            if(deque.peekFirst() < i - A.length) {
                deque.pollFirst();
            }

            ans = Math.max(ans, nums[i] - nums[deque.peekFirst()]);

            while(!deque.isEmpty() && nums[i] <= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return ans;
    }
}
