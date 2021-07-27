package solutions;

/**
 * 1216 Valid Palindrome III
 */
public class ValidPalindromeIII {
    public boolean isValidPalindrome(String s, int k) {

        if(s == null || s.length() == 0) {
            return true;
        }

        int len = s.length();

        int[][] dp = new int[len+1][len+1];

        for(int i = len; i > 0; i--) {
            for(int j = i; j <= len; j++) {
                if(s.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = j - i < 2 ? 0 : dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                }
            }
        }

        return dp[1][len] <= k;
    }
}
