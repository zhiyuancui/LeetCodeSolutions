package solutions;

import java.util.Stack;

public class BasicCalculatorIII {
    public int calculate4(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // initialize operator
        char sign = '+';
        Stack<Long> stack1 = new Stack<>(); // store digit and '('
        Stack<Character> stack2 = new Stack<>(); // store sign before '('
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                long num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                i--;
                stack1.push(eval(sign, stack1, num));
            } else if (ch == ' ') {
                continue;
            } else if (ch == '(') {
                stack1.push(Long.MAX_VALUE);
                stack2.push(sign);
                sign = '+';
            } else if (ch == ')') {
                long num = 0;
                while (stack1.peek() != Long.MAX_VALUE) {
                    num += stack1.pop();
                }
                stack1.pop(); // pop out '(' (Long.MAX_VALUE)
                char operator = stack2.pop();
                stack1.push(eval(operator, stack1, num));
            } else {
                sign = ch;
            }
        }
        // what we need to do is just sum up all num in stack
        int result = 0;
        while (!stack1.isEmpty()) {
            result += stack1.pop();
        }
        return result;
    }

    private long eval(char sign, Stack<Long> stack1, long num) {
        if (sign == '+') {
            return num;
        } else if (sign == '-') {
            return -num;
        } else if (sign == '*') {
            return stack1.pop() * num;
        } else {
            return stack1.pop() / num;
        }
    }
}
