package solutions;

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
        
        s = s.trim().replaceAll(" +","");
        
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
    
    public static void main(String[] args){
    	BasicCalculator b = new BasicCalculator();
    	b.calculate("   1+3-5");
    }
}
