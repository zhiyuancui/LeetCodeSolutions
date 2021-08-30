package solutions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 995 Minimum Number of K Consecutive Bit Flips
 */
public class MinKBitFlips {
    public int minKBitFlips(int[] nums, int k) {
        int res = 0;
        Deque<Integer> queue = new LinkedList<>();

        for(int i = 0; i < nums.length; i++) {
            if(!queue.isEmpty() && i > queue.peek() + k -1) {
                queue.removeFirst();
            }
            if(queue.size() % 2 == nums[i]) {
                if(i + k > nums.length) {
                    return -1;
                }
                queue.add(i);
                res += 1;
            }
        }

        return res;
    }
}
