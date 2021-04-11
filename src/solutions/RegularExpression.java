package solutions;

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

		dp[0][0] = true;

		for(int i = 0; i < len2; i++) {
			if(p.charAt(i) == '*' ) {
				if(dp[0][i-1]) {
					dp[0][i+1] = true;
				}
			}
		}

		for(int i = 0; i < len1; i++) {
			for(int j = 0; j < len2; j++) {
				if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
					dp[i+1][j+1] = dp[i][j];
				}

				if(p.charAt(j) == '*') {
					if(s.charAt(i-1) != p.charAt(j-1) || p.charAt(j-1) != '.') {
						dp[i+1][j+1] = dp[i+1][j-1];// c, a* a*来当做不存在处理
					} else {
						//a, a*        //*重复之前的字符   //*当做不存在   //a*都不存在
						dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1];
					}
				}
			}
		}

		return dp[len1][len2];
	}
}
