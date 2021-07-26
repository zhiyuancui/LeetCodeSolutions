package solutions;

/**
 * 647 Palindromice Substrings
 */
public class PalindromeSubstrings {
	int count = 0;

    /**
     * 你在逗我吗？ 这个居然比dp还要快！
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }


    public int countSubstrings2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();

        boolean[][] dp = new boolean[len][len];

        int count = 0;

        for(int j = 0; j < len; j++) {
            for(int i = 0; i <= j; i++) {
                if(i == j) {
                    dp[i][j] = true;
                    count++;
                }

                if(j-i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                }

                if(j-i > 1 && s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }

}
