package solutions;

import java.util.Stack;

/**
 * 856 Score of Parentheses
 */
public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(0);
            } else {
                int value = stack.pop();
                int prev = stack.pop();
                stack.push(prev + Math.max(2*value, 1));
            }
        }

        return stack.pop();
    }
}
