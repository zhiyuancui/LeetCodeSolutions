package solutions;

import java.util.Stack;

/**
 * 1944 Number of Visible People in a Queue
 */
public class NumberOfVisiblePerson {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;

        Stack<Integer> stack = new Stack<>();

        int[] result = new int[len];

        for(int i = len - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() < heights[i]) {
                result[i]++;
                stack.pop();
            }

            if(!stack.isEmpty()) {
                result[i]++;
            }

            stack.push(heights[i]);
        }

        return result;
    }
}
