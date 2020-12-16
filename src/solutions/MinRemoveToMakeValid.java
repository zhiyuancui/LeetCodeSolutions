package solutions;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        if(s==null||s.length()==0) {
            return "";
        }

        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } if(s.charAt(i) == ')') {
                if(stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }
}
