package solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 764. Largest Plus Sign
 */
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if(n < 1 || mines == null) {
            return 0;
        }

        int[][] grid = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(grid[i], n);
        }

        for(int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0, k = n - 1, left = 0, right = 0, up = 0, down = 0; j < n; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], left = (grid[i][j] == 0 ? 0 : left + 1));

                grid[i][k] = Math.min(grid[i][k], right = (grid[i][k] == 0 ? 0: right + 1));

                grid[j][i] = Math.min(grid[j][i], up = (grid[j][i] == 0 ? 0 : up + 1));
                grid[k][i] = Math.min(grid[k][i], down = (grid[k][i] == 0 ? 0 : down + 1));
            }
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }

        return res;
    }
}
