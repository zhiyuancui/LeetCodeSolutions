package solutions;

import java.util.Stack;

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
     * @param S
     * @return
     */
    public String removeDuplicates2(String S) {
        if(S == null || S.length() == 0) {
            return S;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()) {
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


    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        Stack<Integer> counts = new Stack<>();
        for(int i = 0; i < sb.length(); i++) {
            if(i == 0 || sb.charAt(i) != sb.charAt(i-1)) {
                counts.push(i);
            } else {
                int incre = counts.pop() + 1;
                if(incre == k) {
                    sb.delete(i-k+1,i+1);
                    i = i-k;
                } else {
                    counts.push(incre);
                }
            }
        }

        return sb.toString();
    }
}
