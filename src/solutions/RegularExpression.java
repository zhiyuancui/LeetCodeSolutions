package solutions;

public class RegularExpression {
	
	/**
	 * Recursive 
	 * Reference to https://leetcode.com/discuss/32424/clean-java-solution
	 * http://blog.csdn.net/yusiguyuan/article/details/45014089
	 * c* 可以为空
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
            return s.isEmpty();
        }

		//正常情况
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
	}
	
	
	/**
	 * 
	 * DP Solution
	 * Reference to : https://leetcode.com/discuss/93024/easy-dp-java-solution-with-detailed-explanation
	 */
	public boolean isMatch2(String s, String p) {
		if( s == null || p == null ){
			return false;
		}
		
		boolean[][] dp = new boolean[ s.length() + 1 ][ p.length() + 1 ];
		
		dp[0][0] = true;
		
		for(int i = 0; i < p.length(); i++){
			if( p.charAt(i) == '*' ){
				if(dp[0][i-1] ){
					dp[0][i+1] = true;
				}
			}
		}
		
		for(int i = 0; i < s.length(); i++){
			for(int j = 0; j < p.length(); j++){
				if( p.charAt(j) == '.' ){
					dp[ i + 1 ][ j + 1 ] = dp[i][j];
				}
				if (p.charAt(j) == s.charAt(i)) {
	                dp[i+1][j+1] = dp[i][j];
	            }
				if( p.charAt(j) == '*' ){
					if( p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'){
						dp[i+1][j+1] = dp[i+1][j-1];
					}else{
						dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
					}
				}
			}
		}
		
		return dp[s.length()][p.length()];
	}
}
