package solutions;


/**
 * 730 Count Different Palindromice Subsequences
 */
public class CountDifferentPalindromic {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int mod = 1000000007;
        int[][][] dp = new int[4][n][n];

        for(int i = n -1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                for(int k = 0; k < 4; k++) {
                    char c = (char)('a'+k);
                    if(j== i) {
                        if(s.charAt(i) == c) {
                            dp[k][i][j] = 1;
                        } else {
                            dp[k][i][j] = 0;
                        }
                    } else {
                        if(s.charAt(i) != c) {
                            dp[k][i][j] = dp[k][i+1][j];
                        } else if(s.charAt(j) != c) {
                            dp[k][i][j] = dp[k][i][j-1];
                        } else {
                            if(j == i + 1) {
                                dp[k][i][j] = 2;
                            } else {
                                dp[k][i][j] = 2;
                                for(int m = 0; m < 4; m++) {
                                    dp[k][i][j] += dp[m][i+1][j-1];
                                    dp[k][i][j] %= mod;
                                }
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int k = 0; k < 4; ++k) {
            ans += dp[k][0][n-1];
            ans %= mod;
        }

        return ans;
    }
}
