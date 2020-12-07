package solutions.amazon;

import java.util.Stack;

public class MinimumMove {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack();
        char[] letters = s.toCharArray();

        for(int i =0; i < letters.length; i++) {
            char c = letters[i];
            if(c >= 'a' && c <= 'z') {
                continue;
            }

            if(c=='(') {
                stack.push(i);
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    letters[i] = '_';
                }
            }
        }

        while(!stack.isEmpty()) {
            letters[stack.pop()] = '_';
        }

        StringBuilder sb = new StringBuilder(new String(letters));
        return sb.toString().replaceAll("_","");
    }
}
