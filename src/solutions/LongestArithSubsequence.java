package solutions;

import java.util.HashMap;

public class LongestArithSubsequence {
    public int longestArithSeqLength(int[] A) {
        if(A == null || A.length < 1) {
            return 0;
        }

        int max = 0;

        HashMap<Integer, Integer> dp[] = new HashMap[A.length];

        for(int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
        }

        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                int len = dp[j].getOrDefault(diff, 1) + 1;
                max = Math.max(len, max);
                dp[i].put(diff, len);
            }
        }

        return max;
    }
}
