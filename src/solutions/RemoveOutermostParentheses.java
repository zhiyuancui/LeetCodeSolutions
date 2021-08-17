package solutions;

import java.util.Stack;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        if(S == null || S.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int index = 0;
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c == '(') {
                stack.push('(');
            } else if( c == ')') {
                stack.pop();
            }

            if(stack.isEmpty()) {
                sb.append(S, index+1, i);
                index = i + 1;
            }
        }

        return sb.toString();
    }
}
