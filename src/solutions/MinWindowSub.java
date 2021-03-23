package solutions;

public class MinWindowSub {

    /**
     * https://leetcode.com/problems/minimum-window-subsequence/discuss/608907/Java-not-efficient-but-it-works-SLIDING-WINDOW
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        int[][] dp = new int[n2+1][n1+1];

        int len = n1 + 1, endOfWindow = -1;

        for(int i = 1; i <= n2; i++) {
            for(int j = 1; j <= n1; j++) {
                if(t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = (i != 1 && dp[i-1][j-1] <= 0) ? 0 : 1 + dp[i-1][j-1];

                    if(i == n2 && dp[i][j] != 0 && len > dp[i][j]) {
                        len = dp[i][j];
                        endOfWindow = j - 1;
                    }
                } else {
                    dp[i][j] = (dp[i][j-1] > 0) ? 1 + dp[i][j-1] : 0;
                }
            }
        }

        return len == n1 + 1? "": s.substring(endOfWindow-len+1, endOfWindow+1);
    }


}
