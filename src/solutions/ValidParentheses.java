package solutions;

import java.util.Stack;

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


	/**
	 * Valid Parenthesis String
	 * @param s
	 * @return
	 */
	public boolean checkValidString(String s) {
		return check(s, 0, 0);
	}

	private boolean check(String s, int start, int count) {
		if (count < 0) return false;

		for (int i = start; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				count++;
			}
			else if (c == ')') {
				if (count <= 0) return false;
				count--;
			}
			else if (c == '*') {
				return check(s, i + 1, count + 1) || check(s, i + 1, count - 1) || check(s, i + 1, count);
			}
		}

		return count == 0;
	}

	public boolean checkValidString2(String s) {
		int lo = 0, hi = 0;
		for (char c: s.toCharArray()) {
			lo += c == '(' ? 1 : -1;
			hi += c != ')' ? 1 : -1;
			if (hi < 0) break;
			lo = Math.max(lo, 0);
		}
		return lo == 0;
	}

}
