package solutions;

/**
 * 1062 Longest Repeating Substring
 */
public class LongestRepeatingSubstring {
    public int longestRepeatingSubstring(String s) {
        int len = s.length();

        s = "#"+ s;
        int[][] dp = new int[len + 1][len + 1];

        int longest = 0;

        for(int i = 1; i <= len; i++) {
            for(int j = 1; j <= len; j++) {
                if(i!=j && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    longest = Math.max(longest, dp[i][j]);
                }
            }
        }

        return longest;
    }
}
