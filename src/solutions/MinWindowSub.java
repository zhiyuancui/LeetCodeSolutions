package solutions;

/**
 * 727 Minimum Window Subsequence
 */
public class MinWindowSub {
    public String minWindow(String s1, String s2) {
        if(s1.length() < s2.length()) {
            return "";
        }

        int s1index = 0, s2index = 0;

        int len = Integer.MAX_VALUE;

        int start = -1;

        while(s1index < s1.length()) {
            if(s1.charAt(s1index) == s2.charAt(s2index)) {
                s2index++;
                if(s2index == s2.length()) {
                    int edIndex = s1index;
                    s2index--;
                    while(s2index >= 0) {
                        while(s1.charAt(s1index) != s2.charAt(s2index)) {
                            s1index--;
                        }
                        s2index--;
                        s1index--;
                    }

                    s1index++;
                    s2index++;

                    if(len > edIndex - s1index + 1) {
                        len = edIndex - s1index + 1;
                        start = s1index;
                    }
                }
            }
            s1index++;
        }

        if(start == -1) {
            return "";
        }

        return s1.substring(start, start+len);
    }

    /**
     * DP solution
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
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
