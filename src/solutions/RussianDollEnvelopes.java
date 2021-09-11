package solutions;

import java.util.Arrays;

/**
 * 354 Russian Doll Envelopes
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });

        int[] dp = new int[envelopes.length];

        int result = 0;

        for(int i = 0; i < envelopes.length; i++) {
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            result = Math.max(result, dp[i]);
        }


        return result;
    }
}
