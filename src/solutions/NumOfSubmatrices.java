package solutions;

public class NumOfSubmatrices {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] sumMatrix = new int[row+1][col+1];

        int count = 0;

        for(int i = 0; i < row; i++) {
            int sum = 0;
            for(int j = 0; j < col; j++) {
                sum += matrix[i][j];
                System.out.println(i+","+j+" " + sum);
                if(sum == target && j != 0) {
                    count++;
                }
                sumMatrix[i+1][j+1] = sum + sumMatrix[i][j+1];
            }
        }

        for(int row1 = 0; row1 < row; row1++) {
            for(int row2 = row1; row2 < row; row2++) {
                int sum = 0;
                for(int c=0; c < col; c++) {
                    int total = sum(sumMatrix, row1, c, row2, c);
                    //System.out.println("["+row1+","+c+"]"+" ["+row2+","+c+"] total:" + total);
                    if(total == target) {
                        count++;
                    }
                }
            }
        }

        return count;

    }

    private int sum(int[][] sumMatrix, int x1, int y1, int x2, int y2) {
        return sumMatrix[x1][y1] - sumMatrix[x1][y2+1] - sumMatrix[x2+1][y1] + sumMatrix[x2+1][y2+1];
    }
}
