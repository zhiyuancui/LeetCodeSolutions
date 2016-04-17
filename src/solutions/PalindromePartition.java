package solutions;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	
	public int minCut(String s) {
        char[] array = s.toCharArray();
        
        int n = array.length;
        
        int[] cut = new int[n];
        
        boolean[][] pal = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            int min = i;
            for(int j = 0; j <= i; j++ ){
                if( array[j] == array[i] &&( j + 1 > i - 1 || pal[ j + 1 ][ i - 1 ]) ){
                    pal[ j ][ i ] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[ j - 1 ] + 1 );
                }
            }
            
            cut[i] = min;
        }
        
        return cut[ n - 1 ];
    }
	
	
	/**
	 * Palindrome Partitioning
	 * @param s
	 * @return
	 */
	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        int len = s.length();
        boolean[][] dp = new boolean[ len ][ len ];
        for( int i = 0; i < len; i++ ){
            for(int j = 0; j <= i ; j++){
                if( s.charAt(i) == s.charAt(j) && ( j+1 >= i-1 || dp[j+1][i-1] ) ){
                    dp[j][i] = true;
                }
            }
        }
        
        helper(result, new ArrayList<String>(), dp, s, 0);
        
        return result;
    }
    
    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos ){
        if( pos == s.length() ){
            res.add( new ArrayList<String>( path ) );
            return;
        }
        
        for(int i = pos; i < s.length(); i++){
            if( dp[pos][i] ){
                path.add( s.substring(pos, i+1));
                helper(res, path, dp, s, i+1);
                path.remove( path.size() - 1 );
            }
        }
    }
	
	
}
