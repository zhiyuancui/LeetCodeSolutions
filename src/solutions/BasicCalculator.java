package solutions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BasicCalculator {

	/**
	 * Basic Calculator II
	 * @param s
	 * @return
	 */
public int calculate(String s) {
        
        Stack<Integer> stack = new Stack<Integer>();
        
        s = s.replaceAll("\\s+","");
        
        char sign = '+';
        
        int res = 0, prev = 0;
        
        for(int i =0; i < s.length(); i++){
            if( isDigit( s.charAt(i) ) ){
                prev = 10 * prev + s.charAt(i) - '0';
            }
            if( !isDigit(s.charAt(i)) || i == s.length() - 1 ){
                if( sign == '-' ){
                    stack.push(-prev);
                }else if ( sign == '+' ){
                    stack.push(prev);
                }else{
                    int num;
                    if( sign == '*' ){
                        num = stack.pop() * prev;
                    }else{
                        num = stack.pop() / prev;
                    }
                    stack.push(num);
                }
                sign = s.charAt(i);
                prev = 0;
            }
        }
        
        while( !stack.isEmpty() ){
            res += stack.pop();
        }
        
        return res;
    }
    
    private boolean isDigit(Character c){
        return c >= '0' && c <= '9';
    }
    
    /**
     * Basic Calculator II
     * @param s
     * @return
     */
    public int calculate2(String s) {
        
        if( s == null )
        {
            return 0;
        }
        
        
        
        int length = s.length();
        
        int res = 0;
        long preVal = 0;
        char sign = '+';
        int i = 0;
        
        while( i < length )
        {
            long curVal = 0;
            while( i < length && s.charAt(i) >= '0' && s.charAt(i) <= '9')
            {
                curVal = curVal * 10 + ( s.charAt(i) - '0');
                i++;
            }
            
            if( sign == '+')
            {
                res += preVal;
                preVal = curVal;
            }
            else if( sign == '-')
            {
                res += preVal;
                preVal = - curVal;
            }
            else if( sign == '*')
            {
                preVal = preVal * curVal;
            }
            else if( sign == '/')
            {
                preVal = preVal / curVal;
            }
            
            if( i < length )
            {
                sign = s.charAt(i);
                i++;
            }
            
        }
        
        res += preVal;
        return res;
     }
    
    
    /**
     * Basic Calculator
     */
	public int calculate3(String s) {
		int len = s.length();
	    int sign = 1;
	    int result = 0;
	    
	    Stack<Integer> stack = new Stack<Integer>();
	    for(int i = 0; i < len; i++){
	        if( Character.isDigit(s.charAt(i)) ){
	            int sum = s.charAt(i) - '0';
	            while( i + 1 < len && Character.isDigit( s.charAt( i+1 ) ) ){
	                sum = sum * 10 + s.charAt( i + 1 ) - '0';
	                i++;
	            }
	            
	            result += sum * sign;
	        }
	        else if( s.charAt(i) == '+'){
	            sign = 1;
	        }
	        else if( s.charAt(i) == '-' ){
	            sign = -1;
	        }else if( s.charAt(i) == '(' ){
	            stack.push( result );
	            stack.push( sign );
	            result = 0;
	            sign = 1;
	        }else if( s.charAt(i) == ')' ){
	            result = result * stack.pop() + stack.pop();
	        }
	        
	    }
	    return result;
    }
	
	/**
	 * Basic Calculator III
	 * @param s
	 * @return
	 */
	
	public int calculate4(String s) {
	     if (s == null || s.length() == 0) {
	            return 0;
	        }
	        // initialize operator
	        char sign = '+';
	        Deque<Long> stack1 = new LinkedList<>(); // store digit and '('
	        Deque<Character> stack2 = new LinkedList<>(); // store sign before '('
	        for (int i = 0; i < s.length(); i++) {
	            char ch = s.charAt(i);
	            if (Character.isDigit(ch)) {
	                long num = 0;
	                while (i < s.length() && Character.isDigit(s.charAt(i))) {
	                    num = num * 10 + s.charAt(i++) - '0';
	                }
	                i--;
	                stack1.offerFirst(eval(sign, stack1, num));
	            } else if (ch == ' ') {
	                continue;
	            } else if (ch == '(') {
	                stack1.offerFirst(Long.MAX_VALUE);
	                stack2.offerFirst(sign);
	                sign = '+';
	            } else if (ch == ')') {
	                long num = 0;
	                while (stack1.peekFirst() != Long.MAX_VALUE) {
	                    num += stack1.pollFirst();
	                }
	                stack1.pollFirst(); // pop out '(' (Long.MAX_VALUE)
	                char operator = stack2.pollFirst();
	                stack1.offerFirst(eval(operator, stack1, num));
	            } else {
	                sign = ch;
	            }
	        }
	        // what we need to do is just sum up all num in stack
	        int result = 0;
	        while (!stack1.isEmpty()) {
	            result += stack1.pollFirst();
	        }
	        return result;
	    }
	    private long eval(char sign, Deque<Long> stack1, long num) {
	        if (sign == '+') {
	            return num;
	        } else if (sign == '-') {
	            return -num;
	        } else if (sign == '*') {
	            return stack1.pollFirst() * num;
	        } else {
	            return stack1.pollFirst() / num;
	        }
	    }
}
