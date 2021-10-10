package solutions;

import java.util.Stack;
/**
 * 503 Next Greater Element II
 */
public class NextGreaterElementII {
	public int[] nextGreaterElements(int[] nums) {

        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];

        for(int i = nums.length-1; i >= 0; i--) {
            stack.push(nums[i]);
        }

        for(int i = nums.length -1; i >= 0; i--) {
            res[i] = -1;
            while(!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                res[i] = stack.peek();
            }

            stack.add(nums[i]);
        }

        return res;
    }
}
