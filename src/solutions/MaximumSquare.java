package solutions;

/**
 * 221 Maximal Square
 */
public class MaximumSquare {
	public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        int max = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }
}
