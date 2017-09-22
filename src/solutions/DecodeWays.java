package solutions;

public class DecodeWays {
	public int numDecodings(String s) {
        if( s == null || s.length() == 0 ){
            return 0;
        }
        
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++){
            int first = Integer.valueOf(s.substring(i-1,i));
            int second = Integer.valueOf( s.substring(i-2,i));
            if( first >= 1 && first <= 9 ){
                dp[i] += dp[ i - 1 ];
            }
            if( second >= 10 && second <= 26 ){
                dp[i] += dp[i - 2 ];
            }
        }
        
        return dp[n];
    }
	
	public int numDecodings2(String s) {
        int len = s.length();
        int mod = 1000000007;
        long [] dp = new long[len + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') return 0;
        if (s.charAt(0) == '*'){
            dp[1] = 9;
        }
        else{
            dp[1] = 1;
        }
        for (int i = 2; i<=len; i++) { // i-1 the index of current character in s. 
            if (s.charAt(i-1) == '0') {
                if (s.charAt(i-2) == '1' || s.charAt(i -2) == '2') {
                    dp[i] = dp[i-2];
                }
                else if(s.charAt(i-2) == '*'){
                    dp[i] = 2*dp[i-2];
                }
                else {
                    return 0;
                }
            }
            else if(s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9') {
                dp[i] = dp[i-1];
                if (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6') ){
                    dp[i] = (dp[i] + dp[i-2]) % mod;
                }
                else if (s.charAt(i-2) == '*') {
                    if (s.charAt (i-1) <= '6') {
                        dp[i] = (dp[i] + dp[i-2] * 2) % mod;
                    }
                    else {
                        dp[i] = (dp[i] + dp[i-2]) % mod;
                    }
                }
            }
            else { //s.charAt(i-1) == '*'
                dp[i] = (9*dp[i-1]) % mod;
                if ( s.charAt(i-2) == '1' ){ // 11 - 19
                    dp[i] = ( dp[i] + 9 * dp[i-2] ) % mod;
                }
                else if (s.charAt(i-2) == '2') { // 21 - 26
                    dp[i] = ( dp[i] + 6 * dp[i-2] ) % mod;
                }
                else if (s.charAt(i - 2) == '*') {
                    dp[i] = ( dp[i] + 15 * dp[i-2] ) % mod;
                }
            }
        }
        return (int)dp[len];
    }
	
}
