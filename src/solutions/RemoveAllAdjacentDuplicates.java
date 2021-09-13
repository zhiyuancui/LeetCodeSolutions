package solutions;

import java.util.Stack;

/**
 * 1047 Remove All Adjacent Duplicates in String
 */
public class RemoveAllAdjacentDuplicates {
    public String removeDuplicates(String S) {
        if(S == null || S.length() == 0) {
            return S;
        }

        StringBuilder sb = new StringBuilder();
        int len = 0;
        for(char c : S.toCharArray()) {
            if(len != 0 && c == sb.charAt(len -1)) {
                sb.deleteCharAt(len - 1);
                len--;
            } else {
                sb.append(c);
                len++;
            }
        }

        return sb.toString();
    }

    /**
     *
     * @return
     */
    public String removeDuplicates2(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
