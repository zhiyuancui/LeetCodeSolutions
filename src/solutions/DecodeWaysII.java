package solutions;

public class DecodeWaysII {
    public int numDecodings(String s) {
        if( s == null || s.length() == 0 ) {
            return 0;
        }

        int mod = 1000000007;
        int len = s.length();
        long[] dp = new long[ len + 1 ];
        dp[0] = 1;
        if( s.charAt(0) == '*' ) {
            dp[1] = 9;
        } else if( s.charAt(0) == '0' ) {
            return 0;
        } else {
            dp[1] = 1;
        }

        for( int i = 2; i <= len; i++ ){
            if( s.charAt(i-1) == '0' ) {
                if( s.charAt(i-2) == '1' || s.charAt(i-2) == '2' ) {
                    dp[i] = dp[i-2];
                } else if( s.charAt(i-2) == '*' ) {
                    dp[i] = 2*dp[i-2];
                }
            } else if( s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9' ) {
                dp[i] = dp[i-1];
                if( s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6' ) ){
                    dp[i] = (dp[i] + dp[i-2]) % mod;
                } else if( s.charAt(i-2) == '*' ) {
                    if( s.charAt(i-1) <= '6' ) {
                        dp[i] = (dp[i] + 2*dp[i-2]) % mod;
                    } else {
                        dp[i] = (dp[i] + dp[i-2]) % mod;
                    }
                }
            } else  {
                dp[i] = 9*dp[i-1]%mod;
                if( s.charAt(i-2) == '1' ) {
                    dp[i] = (dp[i] + 9*dp[i-2]) % mod;
                } else if( s.charAt(i-2) == '2' ) {
                    dp[i] = (dp[i] + 6*dp[i-2]) % mod;
                } else if( s.charAt(i-2) == '*' ) {
                    dp[i] = (dp[i] + 15*dp[i-2]) % mod;
                }
            }
        }
        return (int)dp[len];
    }

}
