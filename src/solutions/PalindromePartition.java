package solutions;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	
	
	/**
	 * Palindrome Partition II
	 * @param s
	 * @return
	 */
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
	
    /**
	 * Palindrome Partitioning
	 * Given a string s, partition s such that 
	 * every substring of the partition is a palindrome.
	 * Return all possible palindrome partitioning of s.
	 * For example, given s = "aab",
	 * Return
	 * [
	 *   ["aa","b"],
	 *   ["a","a","b"]
	 * ]
	 */
	public List<List<String>> partition2(String s) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        
        if( s == null || s.length() == 0 )
        {
            return result;
        }
        
        List<String> solution = new ArrayList<String>();
        
        builder(result, solution, 0, s.length(), s);
        
        return result;
    }
    
    private void builder(List<List<String>> result, List<String> solution, int start, int len, String s)
    {
        if( start == len )
        {
            result.add( new ArrayList(solution) );
        }
        
        for(int i = start + 1; i <= len; i++)
        {
            String seg = s.substring(start,i);
            if( validPalindrome(seg) )
            {
                solution.add(seg);
                builder(result, solution, i, len, s);
            }
        }
        
    }
    
    private boolean validPalindrome(String s)
    {
        int start = 0;
        int end  = s.length() - 1;
        
        while( start < end )
        {
            if( s.charAt( start ) != s.charAt(end) )
            {
                return false;
            }
            else
            {
                start++;
                end--;
            }
        }
        
        return true;
        
    }
	
}
