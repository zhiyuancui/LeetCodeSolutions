package solutions.amazon;

public class KnightProbability {
    int[] dx = new int[]{-2,-1,1,2,2,1,-1,-2};
    int[] dy = new int[]{-1,-2,-2,-1,1,2,2,1};

    public double knightProbability(int N, int K, int r, int c) {
        if(N <= 0 || K <= 0) {
            return 1;
        }

        int row = N;

        double[][] dp = new double[N][N];

        dp[r][c] = 1;

        for(; K > 0; K--) {
            double[][] cur = new double[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    for(int k = 0; k < 8; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if(x >= 0 && x < N && y >= 0 && y < N) {
                            cur[x][y] += dp[i][j] / 8.0;
                        }
                    }
                }
            }
            dp = cur;
        }

        double ans = 0.0;
        for(double[] line: dp) {
            for(double x : line) {
                ans += x;
            }
        }
        return ans;
    }
}
