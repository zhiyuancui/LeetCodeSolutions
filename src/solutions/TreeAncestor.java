package solutions;

public class TreeAncestor {
    int[][] dp;
    public TreeAncestor(int n, int[] parent) {
        int log = (int)((Math.log(n)/Math.log(2)) + 1); // find the log of n
        dp = new int[n][log];

        for(int i = 0; i < n; i++) {
            dp[i][0] = parent[i];
        }

        for(int k =1; k < log; k++) {
            for(int i = 0; i < n; i++) {
                if(dp[i][k-1] == -1) {
                    dp[i][k] = -1;
                } else {
                    dp[i][k] = dp[dp[i][k-1]][k-1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        if(node == -1) {
            return -1;
        }

        int step = (int)((Math.log(k)/Math.log(2)));

        if( (1<<step) == k) return dp[node][step];

        return getKthAncestor(dp[node][step], k - (1<<step));
    }
}
