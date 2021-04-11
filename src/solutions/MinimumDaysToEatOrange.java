package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumDaysToEatOrange {
    public int minDays(int n) {
        if(n <= 0) {
            return n;
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i - i /2]+1);
            }
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i - 2*(i/3)]+1);
            }

            dp[i] = Math.min(dp[i], dp[i-1]+1);
        }

        return dp[n];
    }

    Map<Integer,Integer> map = new HashMap<>();
    public int minDays2(int n) {
        if( n <= 2) {
            return n;
        }

        if(map.containsKey(n)) {
            return map.get(n);
        }

        map.put(n, 1 + Math.min(n%2+minDays(n/2), n%3 + minDays(n/3)));

        return map.get(n);
    }
}
