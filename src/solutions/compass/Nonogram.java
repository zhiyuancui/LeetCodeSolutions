package solutions.compass;

import java.util.ArrayList;
import java.util.List;

public class Nonogram {
    public boolean isValidNonogram(int[][] matrix, List<int[]> rows, List<int[]> cols) {
        if(matrix == null || matrix.length == 0 || rows == null || cols == null) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        if(row != rows.size() || col != cols.size()) {
            return false;
        }

        return isNonogramRowsValid(matrix, rows) && isNonogramColsValid(matrix, cols);
    }

    private boolean isNonogramRowsValid(int[][] matrix, List<int[]> rows) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row; i++) {
            int idx = 0;
            int[] instruction = rows.get(i);
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == 0) {
                    if (instruction.length == 0) {
                        return false;
                    }
                    for(int k = 0; k < instruction[idx]; k++) {
                        if(j + k >= col || matrix[i][j+k] != 0) {
                            return false;
                        }
                    }
                    j += rows.get(i)[idx];
                    idx++;
                }
            }
            if(idx != rows.get(i).length) {
                return false;
            }
        }

        return true;
    }

    private boolean isNonogramColsValid(int[][] matrix, List<int[]> cols) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < col; i++) {
            int idx = 0;
            int[] instruction = cols.get(i);
            for(int j = 0; j < row; j++) {
                if(matrix[j][i] == 0) {
                    if (instruction.length == 0) {
                        return false;
                    }
                    for(int k = 0; k < instruction[idx]; k++) {
                        if(j + k >= row || matrix[j+k][i] != 0) {
                            return false;
                        }
                    }
                    j += cols.get(i)[idx];
                    idx++;
                }
            }
            if(idx != cols.get(i).length) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Nonogram n = new Nonogram();
        int[][] matrix = new int[][]{{1,1},{0,0},{0,0},{1,0}};
        List<int[]> rows = new ArrayList<>();
        List<int[]> cols = new ArrayList<>();

        rows.add(new int[]{});
        rows.add(new int[]{2});
        rows.add(new int[]{2});
        rows.add(new int[]{1});

        cols.add(new int[]{1,1});
        cols.add(new int[]{3});

        System.out.println(n.isValidNonogram(matrix, rows, cols));
    }
}
