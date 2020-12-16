package solutions;

import java.util.List;

public class LeftMostColumnWithOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int row = dimensions.get(0);
        int col = dimensions.get(1);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++) {
            int idx = findOne(binaryMatrix, i, col);
            //System.out.println(idx);
            if(idx == -1) {
                min = min != Integer.MAX_VALUE? min: Integer.MAX_VALUE;
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
