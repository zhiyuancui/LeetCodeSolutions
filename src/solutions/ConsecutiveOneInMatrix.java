package solutions;

public class ConsecutiveOneInMatrix {
	public int longestLine(int[][] matrix) {
        int row = matrix.length, max = 0;
        if (row == 0) return max;
        int col = matrix[0].length;
        int[][][] dp = new int[row][col][4];
        for (int i=0;i<row;i++) 
            for (int j=0;j<col;j++) {
                if (matrix[i][j] == 0) continue;
                for (int k=0;k<4;k++) {
                    dp[i][j][k] = 1;
                }
                if (j > 0) {
                    dp[i][j][0] += dp[i][j-1][0]; // horizontal line
                }
                if (j > 0 && i > 0) {
                    dp[i][j][1] += dp[i-1][j-1][1]; // anti-diagonal line
                }
                if (i > 0) {
                    dp[i][j][2] += dp[i-1][j][2]; // vertical line
                }
                if (j < col-1 && i > 0) {
                    dp[i][j][3] += dp[i-1][j+1][3]; // diagonal line
                }
                max = Math.max(max, Math.max(dp[i][j][0], dp[i][j][1]));
                max = Math.max(max, Math.max(dp[i][j][2], dp[i][j][3]));
            }
        return max;
    }
}
