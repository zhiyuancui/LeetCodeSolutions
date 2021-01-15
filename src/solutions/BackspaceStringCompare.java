package solutions;

import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        if(S == null || T == null) {
            return false;
        }

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(char c : S.toCharArray()) {
            if(c=='#') {
                if(!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(c);
            }
        }

        for(char c : T.toCharArray()) {
            if(c=='#') {
                if(!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(c);
            }
        }

        if(stack1.size() != stack2.size()) {
            return false;
        }

        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            char c1 = stack1.pop();
            char c2 = stack2.pop();

            if(c1 != c2) {
                return false;
            }
        }

        return true;
    }
}
