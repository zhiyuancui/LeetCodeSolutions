package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1428 Leftmost Column with at Least a One
 */
public class LeftMostColumnWithOne {
    class BinaryMatrix {
        public List<Integer> dimensions() {
            return new ArrayList<>();
        }

        public int get(int row, int col) {
            return 0;
        }
    }
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int row = dimensions.get(0);
        int col = dimensions.get(1);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++) {
            int idx = findOne(binaryMatrix, i, col);
            //System.out.println(idx);
            if(idx == -1) {
                min = min;
            } else {
                min = Math.min(min, idx);
            }

        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int findOne(BinaryMatrix binaryMatrix, int row, int column) {
        int left = 0;
        int right = column-1;

        while(left < right) {
            int mid = (right-left) / 2 + left;
            if(binaryMatrix.get(row, mid) == 1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return binaryMatrix.get(row, left) == 1 ? left : -1;
    }
}
