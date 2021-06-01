package solutions;

public class MaxPalindromeFromSub {
    public int longestPalindrome(String word1, String word2) {
        if(word1 == null || word2 == null) {
            return 0;
        }

        int len1 = word1.length();
        int len = len1 + word2.length();

        String s = word1 + word2;

        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        int res = 0;

        for(int i = len - 2; i >= 0; i--) {
            for(int j = i + 1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                    if( i < len1 && j >= len1 ) {
                        res = Math.max(res, dp[i][j]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }


        return res;
    }
}
