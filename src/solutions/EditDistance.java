package solutions;

public class EditDistance {
	public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i< m+1; i++){
            dp[0][i] = i; 
        }
        for(int i=0; i<n+1; i++){
            dp[i][0] = i;
        }
        
        
        for(int i = 1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }
	
	
	/**
	 * One Edit Distance
	 * 
	 * Given two strings S and T, determine if they are both one edit distance apart.
	 * 
	 * Reference to :https://leetcode.com/discuss/71071/my-clear-java-solution-with-explanation
	 * 
	 */
	public boolean isOneEditDistance(String s, String t) {
        for(int i = 0; i < Math.min(s.length(), t.length()); i++){
        	if( s.charAt(i) != t.charAt(i) ){
        		if( s.length() == t.length() ){
        			return s.substring(i+1).equals(t.substring(i+1));
        		}else if( s.length() < t.length() ){
        			return s.substring(i).equals(t.substring(i+1));
        		}else{
        			return t.substring(i).equals(s.substring(i+1));
        		}
        	}
        }
        
        return Math.abs(s.length() - t.length() ) == 1;
    }
}
