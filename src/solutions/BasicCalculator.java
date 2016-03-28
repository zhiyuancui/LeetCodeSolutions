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
    
    public static void main(String[] args){
    	BasicCalculator b = new BasicCalculator();
    	b.calculate("   30");
    }
}
