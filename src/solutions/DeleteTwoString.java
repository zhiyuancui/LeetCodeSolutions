package solutions;


public class DeleteTwoString {
	public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int dp[][] = new int[ len1 ][ len2 ];
        for(int i = 0; i <= len1; i++){
            for(int j = 0; j <= len2; j++){
                if( i == 0 || j == 0 ){
                  dp[i][j] = 0;  
                } 
                else {
                    dp[i][j] = (word1.charAt(i-1) == word2.charAt(j-1)) ? dp[i-1][j-1] + 1 : Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        int val = dp[len1][len2];
        return len1 + len2 - 2 * val;
    }
}
