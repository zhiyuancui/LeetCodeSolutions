package solutions;

/**
 * 920 Number of Music Playlists
 */
public class NumberOfMusicPlaylists {
    public int numMusicPlaylists(int n, int goal, int k) {
        if(n <= 0) {
            return 0;
        }

        long[][] dp = new long[goal+1][n+1];

        int mod = 1000000007;

        dp[0][0] = 1;

        for(int i = 1; i <= goal; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] += dp[i-1][j-1] * (n-j+1);
                dp[i][j] += dp[i-1][j] * Math.max(j-k, 0);

                dp[i][j] %= mod;
            }
        }

        return (int)dp[goal][n];
    }
}
