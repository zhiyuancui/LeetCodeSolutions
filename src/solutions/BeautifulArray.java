package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 932 Beautiful Array
 * https://leetcode-cn.com/problems/beautiful-array/solution/piao-liang-shu-zu-by-leetcode/
 */
public class BeautifulArray {
    Map<Integer, int[]> memo = new HashMap<>();

    public int[] beautifulArray(int n) {
        return backtrack(n);
    }

    public int[] backtrack(int n) {
        if(memo.containsKey(n)) {
            return memo.get(n);
        }

        int[] ans = new int[n];

        if(n == 1) {
            ans[0] = 1;
        } else {
            int idx = 0;
            for(int x : backtrack((n+1)/2)) {
                ans[idx] = 2*x - 1;
                idx++;
            }
            for(int x : backtrack(n/2)) {
                ans[idx] = 2*x;
                idx++;
            }
        }

        memo.put(n, ans);
        return ans;
    }
}
