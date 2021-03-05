package solutions;

public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        if(mat == null || mat.length == 0) {
            return new int[0][0];
        }

        int row = mat.length;
        int col = mat[0].length;

        int[][] result = new int[row][col];
        int[][] sumMatrix = new int[row+1][col+1];

        for(int i = 0; i < row; i++) {
            int sum = 0;
            for(int j = 0; j < col; j++) {
                sum += mat[i][j];
                sumMatrix[i+1][j+1] = sum + sumMatrix[i][j+1];
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int rx1 = i - K < 0 ? 0 : i - K;
                int rx2 = i + K >= row ? row - 1 : i + K;
                int cy1 = j - K < 0 ? 0 : j - K;
                int cy2 = j + K >= col ? col - 1: j + K;
                result[i][j] = getSum(sumMatrix, rx1, cy1, rx2, cy2);
            }
        }


        return result;
    }

    private int getSum(int[][] sumMatrix, int x1, int y1, int x2, int y2) {
        return sumMatrix[x1][y1] + sumMatrix[x2+1][y2+1] - sumMatrix[x2+1][y1] - sumMatrix[x1][y2+1];
    }
}
