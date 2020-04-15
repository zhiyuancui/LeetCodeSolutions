package solutions.amazon;

public class MergeStones {
    int n, k;
    long[][][] dp;
    int[] sum;
    int inf = Integer.MAX_VALUE;
    public int mergeStones(int[] ss, int K) {
        n = ss.length;
        k = K;
        if (n == 1) return 0;
        if ( (n - 1) % (k - 1) != 0) return -1;
        sum = new int[n + 1];
        dp = new long[n + 1][n + 1][n + 1];   //use n + 1 to avoid out of bound exception on cnt;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + ss[i];
        }
        int res = (int) dfs(0, n - 1, 1);
        return res < inf ? res : -1;
    }

    private long dfs(int st, int ed, int cnt) {
        if (dp[st][ed][cnt] > 0) return dp[st][ed][cnt];
        long res = inf;
        if ((ed - st + 1 - cnt) % (k - 1) > 0) return inf;
        if (st == ed) res = cnt == 1 ? 0 : inf;  //if cnt == 1, cost is 0;
        else if (cnt == 1) res = dfs(st, ed, k) + sum[ed + 1] - sum[st];
        else {
            for (int i = st; i < ed; i++) {  //start from st, other than st + 1;
                res = Math.min(res, dfs(st, i, 1) + dfs(i+1, ed, cnt - 1));
            }
        }
        dp[st][ed][cnt] = res;
        return res;
    }
}
