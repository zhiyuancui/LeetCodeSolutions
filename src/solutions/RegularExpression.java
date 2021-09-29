package solutions;

/**
 * 10 Regular Expression Matching
 */
public class RegularExpression {
	
	/**
	 * Recursive 
	 * Reference to https://leetcode.com/discuss/32424/clean-java-solution
	 * http://blog.csdn.net/yusiguyuan/article/details/45014089
	 * c* could be empty
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
            return s.isEmpty();
        }

		// check the first character and the second character is no *
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.isEmpty() || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        //P.length() >=2
        //aa : a*
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {  
            if (isMatch(s, p.substring(2))) { 
                return true;                     
            }                                    
            s = s.substring(1);
        }
        //a : c*
        return isMatch(s, p.substring(2));
        // the second character in P is *, 
        //but the first character is not match. use * to remove the first two character.
	}
	
	
	/**
	 * 
	 * DP Solution
	 * Reference to : https://leetcode.com/discuss/93024/easy-dp-java-solution-with-detailed-explanation
	 */
	public boolean isMatch2(String s, String p) {
		if(s == null || p == null) {
			return false;
		}

		int len1 = s.length();
		int len2 = p.length();

		boolean[][] dp = new boolean[len1+1][len2+1];

		dp[len1][len2] = true;

		for(int i = len1; i >= 0; i--) {
			for(int j = len2-1; j >= 0; j--) {
				boolean firstMatch = i < len1 && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

				if( j < p.length() - 1 && p.charAt(j+1) =='*') {
					dp[i][j] = dp[i][j+2] || firstMatch && dp[i+1][j];
				} else {
					dp[i][j] = firstMatch && dp[i+1][j+1];
				}
			}
		}

		return dp[0][0];
	}
}
