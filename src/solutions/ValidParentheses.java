package solutions;

import java.util.Stack;

/**
 * 20 Valid Parentheses
 */
public class ValidParentheses {
	public boolean isValid(String s) {
	     
	     if( s == null || s.length() == 0 )
	     {
	         return false;
	     }  
	     
	     Stack<Character> stack = new Stack<Character>();
	     
	     for(int i = 0; i < s.length(); i++)
	     {
	         if(s.charAt(i) =='('||s.charAt(i) =='{'||s.charAt(i) =='[')
	         {
	             stack.push( s.charAt(i) );
	         }
	         else
	         {
	             if( !stack.isEmpty() )
	             {
	                 if( check( stack.peek(), s.charAt(i) ) )
	                 {
	                     stack.pop();
	                 }
	                 else
	                 {
	                     return false;
	                 }
	             }
	             else
	             {
	                 return false;
	             }
	         }
	     }
	     
	     return stack.isEmpty();
	     
	    }
	    
	    private boolean check(Character c1, Character c2 )
	    {
	        return (c1 == '(' && c2 ==')') || (c1 == '[' && c2 ==']' )|| (c1 == '{' && c2 =='}');
	    }

}
