package solutions;

import java.util.Stack;

/**
 * 316 Remove Duplicate Letters
 */
public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        int[] count = new int[26];
        boolean[] added = new boolean[26];
        
        for( char ch : s.toCharArray() ){
            count[ch - 'a']++;
        }
        
        for(char ch : s.toCharArray() ){
            
            count[ch - 'a']--;
            
            if( added[ch - 'a'] ){
                continue;
            }
            
            while( !stack.isEmpty() && stack.peek() > ch && count[ stack.peek() - 'a'] > 0 ){
                added[ stack.pop() - 'a'] = false;
            }
            
            stack.push( ch );
            added[ch-'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while( !stack.isEmpty() ){
            sb.append( stack.pop() );
        }
        
        return sb.reverse().toString();
    }
}
