package solutions;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		if( s == null || s.length() == 0 ) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        int idx = 0;
        Stack<Integer> countStack = new Stack<>();
        Stack<String> sbStack = new Stack<>();
        
        while( idx < s.length() ) {
            if( Character.isDigit(s.charAt(idx)) ) {
                int count = 0;
                while( idx < s.length() && Character.isDigit( s.charAt(idx) ) ) {
                    count = count * 10 + ( s.charAt(idx) - '0' );
                    idx++;
                }
                countStack.push( count );
            } else if( s.charAt(idx) == '[' ) {
                sbStack.push( result.toString() );
                result = new StringBuilder();
                idx++;
            } else if( s.charAt(idx) == ']' ) {
                StringBuilder prev = new StringBuilder( sbStack.pop() );
                int count = countStack.pop();
                for(int i = 0; i < count; i++) {
                    prev.append( result.toString() );
                }
                
                result = prev;
                idx++;
                
            } else {
                result.append( s.charAt(idx) );
        
                idx++;
            }
        }
        
        return result.toString();
        
    }
}
