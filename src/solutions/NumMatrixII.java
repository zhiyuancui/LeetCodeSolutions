package solutions;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Referenct to https://leetcode.com/discuss/71169/java-2d-binary-indexed-tree-solution-clean-and-short-17ms
 * @author Zhiyuan
 *
 */

public class NumMatrixII {

    int row = 0;
    int col = 0;
    int[][] copy;
    int[][] BITree;

    public NumMatrixII(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        row = matrix.length;
        col = matrix[0].length;

        copy = new int[row][col];
        BITree = new int[row+1][col+1];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                update(i,j, matrix[i][j]);
                copy[i][j] = matrix[i][j];
            }
        }
    }

    public void update(int i, int j, int val) {
        int diff = val - copy[i][j];

        copy[i][j] = val;

        i++;
        j++;
        while(i <= row) {
            int k = j;
            while(k <= col) {
                BITree[i][k] += diff;
                k += k & (-k);
            }
            i += i & (-i);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) - sum(row1-1, col2) - sum(row2, col1-1) + sum(row1-1, col1-1);
    }

    private int sum(int i, int j){
        int sum = 0;
        i++;
        j++;
        while(i > 0) {
            int k = j;
            while(k > 0) {
                sum += BITree[i][k];
                k -= k & (-k);
            }
            i -= i & (-i);
        }

        return sum;
    }
}
