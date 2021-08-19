package solutions;

import java.util.Stack;

/**
 * 150 Evaluate Reverse Polish Notation
 */
public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
        
        if( tokens == null || tokens.length == 0 ){
            return 0;
        }
        
        Stack<String> stack = new Stack<String>();
        
        for(String token : tokens){
            if( token.equals("+") || token.equals("/") || token.equals("-") || token.equals("*") ){
                int val1 = Integer.parseInt( stack.pop() );
                int val2 = Integer.parseInt( stack.pop() );
                int result = 0;
                switch( token ){
                    case "+":
                        result = val1 + val2;
                        break;
                    case "-":
                        result = val2 - val1;
                        break;
                    case "*":
                        result = val1 * val2;
                        break;
                    case "/":
                        result = val2 / val1;
                        break;
                }
                stack.push( Integer.toString( result ) );
                
            }else{
                stack.push(token);
            }
        }
        
        return Integer.parseInt( stack.pop() );
    }
}
