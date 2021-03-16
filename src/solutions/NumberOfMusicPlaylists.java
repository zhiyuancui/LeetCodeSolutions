package solutions;

public class NumberOfMusicPlaylists {
    public int numMusicPlaylists(int N, int L, int K) {
        if(N <= 0) {
            return 0;
        }

        int mod = 1000000007;

        long[][] dp = new long[L+1][N+1];

        dp[0][0] = 1;

        for(int i = 1; i <= L; i++) {
            for(int j = 1; j <= N; j++) {
                dp[i][j] += dp[i-1][j-1] * (N-j+1);
                dp[i][j] += dp[i-1][j] * Math.max(j-K, 0);
                dp[i][j] %=mod;
            }
        }

        return (int)dp[L][N];

    }
}
