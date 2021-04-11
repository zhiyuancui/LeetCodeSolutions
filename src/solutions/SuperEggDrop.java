package solutions;

// https://leetcode.com/problems/super-egg-drop/discuss/792736/CPP-Explained-Recursive-greatermemoization-greateroptimization-greaterDP-oror-Well-Explained-oror-Easy-to-unserstand
public class SuperEggDrop {
    public int superEggDrop(int k, int n) {
        if(k < 0 || n < 0) {
            return 0;
        }

        if(k == 1) {
            return n;
        }

        int[][] dp = new int[k+1][n+1];

        for(int i = 0; i <= k; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for(int i = 0; i <= n; i++) {
            dp[0][i] = 0;
            dp[1][i] = i;
        }

        for(int i = 2; i < k +1; i++) {
            for(int j = 2; j <n+1; j++) {
                int left = 1;
                int end = j;
                int temp = 0;
                int ans = Integer.MAX_VALUE;

                while(left <= end) {
                    int mid = (left+end) / 2;
                    int before = dp[i-1][mid-1];
                    int after = dp[i][j-mid];

                    temp = 1 + Math.max(before, after);

                    if(before < after) {
                        left = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                    ans = Math.min(ans, temp);
                }
                dp[i][j] = ans;
            }
        }

        return dp[k][n];
    }
}
