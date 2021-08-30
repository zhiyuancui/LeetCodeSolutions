package solutions;

/**
 * 562 Longest Line of Consecutive One in Matrix
 */
public class LongestLine {
    public int longestLine(int[][] mat) {
        if(mat ==  null || mat.length == 0) {
            return 0;
        }
        int row = mat.length;
        int col = mat[0].length;

        int[][][] dp = new int[row][col][4];

        int max = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(mat[i][j] == 0) {
                    continue;
                }

                for(int k = 0; k < 4; k++) {
                    dp[i][j][k] = 1;
                }

                if(j > 0) { // from left
                    dp[i][j][0] += dp[i][j-1][0];
                }

                if(i > 0) {// from top
                    dp[i][j][1] += dp[i-1][j][1];
                }

                if(j > 0 && i > 0) { // from left top
                    dp[i][j][2] += dp[i-1][j-1][2];
                }

                if(j < col - 1 && i > 0) {//from right top
                    dp[i][j][3] += dp[i-1][j+1][3];
                }

                max = Math.max(max, Math.max(dp[i][j][0], Math.max(dp[i][j][1], Math.max(dp[i][j][2], dp[i][j][3]))));
            }
        }

        return max;
    }
}
