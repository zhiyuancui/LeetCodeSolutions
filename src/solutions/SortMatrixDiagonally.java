package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {

        if(mat == null || mat.length == 0) {
            return new int[0][0];
        }

        int row = mat.length;
        int col = mat[0].length;

        Map<Integer, Queue<Integer>> diagonals = new HashMap<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                diagonals.putIfAbsent(i - j, new PriorityQueue<>());
                diagonals.get(i - j).add(mat[i][j]);
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                mat[i][j] = diagonals.get(i-j).remove();
            }
        }

        return mat;
    }
}
