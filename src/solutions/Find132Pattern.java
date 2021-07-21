package solutions;

import java.util.Stack;

/**
 * 456 132 Pattern
 * https://leetcode-cn.com/problems/132-pattern/solution/xiang-xin-ke-xue-xi-lie-xiang-jie-wei-he-95gt/
 */
public class Find132Pattern {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        int middle = Integer.MIN_VALUE;

        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < middle) {
                return true;
            }
            while(!stack.isEmpty() && stack.peek() < nums[i]) {
                middle = Math.max(middle, stack.pop());
            }

            stack.push(nums[i]);
        }

        return false;
    }
}
