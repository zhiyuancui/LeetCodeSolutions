package solutions;

/**
 * 
 * Reference to: https://leetcode.com/discuss/54278/my-java-dp-solution-using-2d-table
 * @author Zhiyuan
 *
 */
public class WildCardMatch {
	public boolean isMatch(String s, String p) {
		int lenS = s.length();
		int lenP = p.length();
		
        boolean[][] match = new boolean[ lenS + 1 ][ lenP + 1 ];
        match[ lenS ][ lenP ] =true;
        
        for(int i = lenP - 1; i >= 0; i--){
        	if( p.charAt(i) != '*' ){
        		break;
        	}else{
        		match[ lenS ][i] = true;
        	}
        }
        
        for(int i = lenS - 1; i >= 0; i--){
        	for(int j = lenP - 1; j>=0;j--){
        		if( s.charAt(i) == p.charAt(j) || p.charAt(j) == '?' ){
        			match[i][j] = match[i+1][j+1];
        		}else if( p.charAt(j) == '*' ){
        			match[i][j] = match[i+1][j] || match[i][j+1];
        		}else{
        			match[i][j] = false;
        		}
        	}
        }
        
        return match[0][0];
    }
}
