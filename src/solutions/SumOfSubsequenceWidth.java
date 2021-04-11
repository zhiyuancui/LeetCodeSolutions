package solutions;

import java.util.Arrays;

public class SumOfSubsequenceWidth {
    public int sumSubseqWidths(int[] A) {
        if(A == null || A.length < 0) {
            return 0;
        }

        int len = A.length, mod = 1000000007;

        long sum = 0;
        Arrays.sort(A);
        long[] dp = new long[len];

        dp[0] = 1;
        for(int i = 1; i < len; i++) {
            dp[i] = (dp[i-1]*2) % mod;
        }

        for(int i = 0; i < len; i++) {
            sum = ( sum + (A[i] * (dp[i] - dp[len - 1 - i])) ) % mod;
        }

        return (int)(sum % mod);
    }
}
