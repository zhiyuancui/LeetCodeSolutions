package solutions;

public class FreedomTrail {
	/**
	 * Reference to : http://www.cnblogs.com/grandyang/p/6675879.html
	 * @param ring
	 * @param key
	 * @return
	 */
	public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n];
        //dp[i][j]表示转动从i位置开始的key串所需要的最少步数(这里不包括spell的步数，因为spell可以在最后统一加上)，
        //此时表盘的12点位置是ring中的第j个字符。
        //不得不佩服这样的设计的确很巧妙，我们可以从key的末尾往前推，
        //这样dp[0][0]就是我们所需要的结果，因为此时是从key的开头开始转动，而且表盘此时的12点位置也是ring的第一个字符。
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }
        
        return dp[0][0] + m;
    }
}
