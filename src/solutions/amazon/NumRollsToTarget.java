package solutions.amazon;

import java.util.HashMap;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.MOD;

/**
 * 1155 Number of Dice Rolls With Target Sum
 * https://leetcode-cn.com/problems/number-of-dice-rolls-with-target-sum/solution/zuo-ti-guo-cheng-ji-lu-dpjie-fa-by-maverickbytes/
 */
public class NumRollsToTarget {
    public int numRollsToTarget(int d, int f, int target) {
        int MOD = 1000000000 + 7;

        int[][] dp = new int[31][1001];

        int min = Math.min(f, target);

        for(int i = 1; i <= min; i++) {
            dp[1][i] = 1;
        }

        int max = d * f;

        for(int i = 2; i <= d; i++) {//扔的次数
            for(int j = i; j <= max; j++) { //扔i次的时候的和j
                for(int k = 1; j -k >= 0 && k <= f; k++) {//扔的点数
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k]) % MOD;
                }
            }
        }


        return dp[d][target];
    }
}
