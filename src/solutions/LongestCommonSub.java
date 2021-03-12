package solutions;

public class LongestCommonSub {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++)
                dp[i+1][j+1] = chars1[i] == chars2[j]? dp[i][j] + 1 : Math.max(dp[i][j+1], dp[i+1][j]);
        }
        return dp[chars1.length][chars2.length];


    }
}
