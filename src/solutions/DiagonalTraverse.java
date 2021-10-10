package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 498 Didgonal Traverse
 */
public class DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int row = matrix.length, col = matrix[0].length;
        
        int[] result = new int[row * col];
        int x = 0, y = 0, d = 1;

        for (int i = 0; i < row * col; i++) {
            result[i] = matrix[x][y];
            x -= d;
            y += d;
            if (x >= row) { x = row - 1; y += 2; d = -d;}
            if (y >= col) { y = col - 1; x += 2; d = -d;}
            if (x < 0)  { x = 0; d = -d;}
            if (y < 0)  { y = 0; d = -d;}
        }
        
        return result;
    }
}
