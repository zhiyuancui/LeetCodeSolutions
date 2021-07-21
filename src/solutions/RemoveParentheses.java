package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301 Remove Invalid Parentheses
 */
public class RemoveParentheses {
	
	public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<String>();
        
        int remainLeft = 0;//The left parentheses remain
        int remainRight = 0;//The right parentheses remain
        
        for(int i = 0; i < s.length(); i++){
        	if( s.charAt(i) == '(' ){
        		remainLeft++;
        	}
        	if( s.charAt(i) == ')' ){
        		if( remainLeft != 0 ){
        			remainLeft--;
        		}else{
        			remainRight++;
        		}
        	}
        }
        
        DFS(res, s,0,remainLeft, remainRight,0, new StringBuilder() );
        return new ArrayList<String>( res );
    }
	
	/**
	 * 
	 * @param result
	 * @param s
	 * @param index
	 * @param leftRemain
	 * @param rightRemain
	 * @param open
	 * @param sb
	 */
	private void DFS(Set<String> result, String s, int index, int leftRemain, int rightRemain, int open, StringBuilder sb){
		if( index == s.length() && leftRemain == 0 && rightRemain == 0 && open == 0 ){
			result.add( sb.toString() );
			return;
		}
		
		if( index == s.length() || leftRemain < 0 || rightRemain < 0 || open < 0 ){
			return;
		}
		
		char cur = s.charAt(index);
		int len = sb.length();
		
		if( cur == '(' ){
			DFS(result, s, index+1, leftRemain -1, rightRemain,open,sb);
			DFS(result,s, index+1, leftRemain, rightRemain, open + 1, sb.append(cur));
		}else if( cur == ')' ){
			DFS(result, s, index+1, leftRemain, rightRemain - 1, open, sb);
			DFS(result, s, index + 1, leftRemain, rightRemain, open -1, sb.append(cur));
		}else{
			DFS(result, s, index + 1, leftRemain, rightRemain, open, sb.append(cur));
		}
		
		sb.setLength(len);
	}
}
