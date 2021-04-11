package solutions;

/**
 * 
 * Reference to: https://leetcode.com/discuss/54278/my-java-dp-solution-using-2d-table
 * @author Zhiyuan
 *
 */
public class WildCardMatch {
	public boolean isMatch(String s, String p) {
		if(s == null || p == null) {
			return false;
		}

		int len1 = s.length();
		int len2 = p.length();

		boolean[][] dp = new boolean[len1+1][len2+1];

		dp[len1][len2] = true;

		for(int i = len2 -1; i >= 0; i--) {
			if(p.charAt(i) != '*') {
				break;
			} else {
				dp[len1][i] = true;
			}
		}

		for(int i = len1 - 1; i >= 0; i--) {
			for(int j = len2 - 1; j >= 0; j--) {
				if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
					dp[i][j] = dp[i+1][j+1];
				} else if(p.charAt(j) == '*') {
					             // * match任意字符    //* 不存在
					dp[i][j] = dp[i+1][j] || dp[i][j+1];
				} else {
					dp[i][j] = false;
				}
			}
		}

		return dp[0][0];
	}
}
