package solutions;

import java.util.Stack;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		if( k == num.length() ) {
            return "0";
        }
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push( c );
        }
        
        while(k>0){//corner case like "1111"
            stack.pop();
            k--;            
        }
        
        // find the index of first non-zero digit
        StringBuilder sb = new StringBuilder();
        while( !stack.isEmpty() ) {
            sb.append( stack.pop() );
        }
        
        sb.reverse();
        while( sb.length() > 1 && sb.charAt(0) == '0' ) {
            sb.deleteCharAt(0);
        }
        return sb.toString();// 9, 1 //10, 2//100 1
    }
}
