package solutions;

import java.util.Stack;

/**
 * 946 Validate Stack Sequences
 */
public class ValidStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;

        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for(int num : pushed) {
            stack.push(num);

            while(!stack.isEmpty() && j < n && stack.peek() == popped[j] ) {
                stack.pop();
                j++;
            }
        }

        return j == n;
    }
}
