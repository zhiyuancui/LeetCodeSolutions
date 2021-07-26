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

    class Point {
        int row;
        int sum;
        int val;
        Point(int row,int sum,int val) {
            this.row = row;
            this.sum = sum;
            this.val = val;
        }

    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if(nums == null) {
            return new int[0];
        }

        ArrayList<Point> list = new ArrayList<>();

        for(int row = 0; row < nums.size(); row++) {
            List<Integer> line = nums.get(row);
            for(int col = 0; col < line.size(); col++) {
                list.add(new Point(row, row+col, line.get(col)));
            }
        }

        Collections.sort(list, (a, b) -> {
            if(a.sum == b.sum) {
                return b.row - a.row;
            } else {
                return a.sum - b.sum;
            }
        });

        int[] res = new int[list.size()];

        for(int i = 0; i< list.size(); i++) {
            res[i] = list.get(i).val;
        }

        return res;
    }
}
