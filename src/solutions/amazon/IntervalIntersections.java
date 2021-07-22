package solutions.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * 986 Interval List Intersections
 */
public class IntervalIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A == null || B == null) {
            return new int[0][0];
        }

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < A.length && j < B.length) {
            int low = Math.max(A[i][0], B[j][0]);
            int high = Math.min(A[i][1], B[j][1]);

            if(low <= high) {
                result.add(new int[]{low, high});
            }

            if(A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        int[][] res = new int[result.size()][2];

        for(int k = 0; k < res.length; k++) {
            res[k][0] = result.get(k)[0];
            res[k][1] = result.get(k)[1];
        }

        return res;
    }

}
