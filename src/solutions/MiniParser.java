package solutions;

import java.util.Stack;

import util.NestedInteger;

/**
 * 385 Mini Parser
 */
public class MiniParser {
	public NestedInteger deserialize(String s) {
        if (s.isEmpty()){
        		return null;
        }
	    if (s.charAt(0) != '[') {// ERROR: special case
	        return new NestedInteger(Integer.valueOf(s));
	    }   
	    Stack<NestedInteger> stack = new Stack<>();
	    NestedInteger result = null;
	    int l = 0; // l shall point to the start of a number substring; 
	               // r shall point to the end+1 of a number substring
	    for (int r = 0; r < s.length(); r++) {
	        char ch = s.charAt(r);
	        if (ch == '[') {
	            if (result != null) {
	                stack.push(result);
	            }
	            result = new NestedInteger();
	            l = r+1;
	        } else if (ch == ']') {
	            String num = s.substring(l, r);
	            if (!num.isEmpty())
	                result.add(new NestedInteger(Integer.valueOf(num)));
	            if (!stack.isEmpty()) {
	                NestedInteger pop = stack.pop();
	                pop.add(result);
	                result = pop;
	            }
	            l = r+1;
	        } else if (ch == ',') {
	            if (s.charAt(r-1) != ']') {
	                String num = s.substring(l, r);
	                result.add(new NestedInteger(Integer.valueOf(num)));
	            }
	            l = r+1;
	        }
	    }
	    return result;
    }
}
