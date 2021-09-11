package solutions;

/**
 * 115 Distinct Subsequences
 */
public class DistinctSubsequence {
	public int numDistinct(String s, String t) {
		if(s == null || t == null) {
			return 0;
		}

		int len1 = s.length();
		int len2 = t.length();

		int[][] dp = new int[len2 + 1][len1 + 1];

		for(int i = 0; i <= len1; i++) {
			dp[0][i] = 1;
		}

		for(int i = 0; i < t.length(); i++) {
			for(int j = 0; j < s.length(); j++) {
				if(t.charAt(i) == s.charAt(j)) {
					dp[i+1][j+1] = dp[i][j] + dp[i+1][j];
				} else {
					dp[i+1][j+1] = dp[i+1][j];
				}
			}
		}

		return dp[len2][len1];
	}
}
