package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinPath {
    public List<Integer> cheapestJump(int[] A, int B) {
        int[] next = new int[A.length];
        long[] dp = new long[A.length];

        Arrays.fill(next, -1);
        List<Integer> res = new ArrayList<>();

        for(int i = A.length - 2; i >= 0; i--) {
            long min = Integer.MAX_VALUE;

            for(int j = i+1; j <= i +B && j < A.length; j++) {
                if(A[j] >= 0) {
                    long cost = A[i] + dp[j];
                    if(cost < min) {
                        min = cost;
                        next[i] = j;
                    }
                }
            }
            dp[i] = min;
        }

        int i;
        for(i =0; i < A.length && next[i] > 0; i =next[i]) {
            res.add(i+1);
        }

        if(i == A.length - 1 && A[i] >= 0) {
            res.add(A.length);
        } else {
            return new ArrayList<>();
        }

        return res;
    }
}
