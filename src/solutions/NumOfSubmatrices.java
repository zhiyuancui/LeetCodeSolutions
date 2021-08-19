package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 1074 Number of Submatrics That Sum to Target
 */
public class NumOfSubmatrices {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 1; j < col; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for(int i =0 ; i < col; i++) {
            for(int j = i; j < col; j++) {
                map.clear();
                map.put(0,1);
                int sum = 0;
                for(int k = 0; k < row; k++) {
                    sum += matrix[k][j] - (i == 0 ? 0 : matrix[k][i-1]);

                    if(map.containsKey(sum - target)) {
                        count += map.get(sum - target);
                    }
                    map.put(sum, map.getOrDefault(sum, 0) +1);
                }
            }
        }

        return count;
    }
}
