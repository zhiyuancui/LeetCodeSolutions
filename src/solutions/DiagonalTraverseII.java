package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverseII {
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
