package solutions;

import java.util.Stack;

/**
 * 32 Longest Valid Parentheses
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int result = 0;
        int temp = 0;
        
        Stack<Integer> s1 = new Stack<Integer>();
        int[] data = new int[ s.length() ];
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if( c == '(' ){
                s1.push(i);
            }else{
                if( !s1.isEmpty() ){
                    data[i] = 1;
                    data[ s1.pop() ] = 1;
                }
            }
        }
        
        for(int i : data){
            if( i == 1 ){
                temp++;
            }else{
                result = Math.max(result, temp);
                temp = 0;
            }
        }
        
        return Math.max(temp, result);
    }
}
