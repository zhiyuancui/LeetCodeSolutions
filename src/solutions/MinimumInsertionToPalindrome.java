package solutions;

// https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/solution/rang-zi-fu-chuan-cheng-wei-hui-wen-chuan-de-zui--2/
public class MinimumInsertionToPalindrome {
    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for(int i = s.length() -1; i >= 0; i--) {
            dp[i][i] = 1;
            for(int j = i+1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return len - dp[0][s.length()-1];

    }

    public int minInsertions2(String s) {
         int len = s.length();
         int[][] dp = new int[len+1][len+1];


         String t = reverse(s);

         for(int i = 1; i <= len; i++) {
             for(int j = 1; j <= len; j++) {
                 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                 if(s.charAt(i-1) == t.charAt(j-1)) {
                     dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                 }
             }
         }

         return len - dp[len][len];
     }

     private String reverse(String s) {
         StringBuilder sb = new StringBuilder(s);
         return sb.reverse().toString();
     }
}
