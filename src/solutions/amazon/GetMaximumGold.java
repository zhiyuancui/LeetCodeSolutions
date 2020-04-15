package solutions.amazon;

import java.util.Arrays;

public class GetMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i<grid.length; i++)
            for (int j = 0; j< grid[0].length; j++)
                if (grid[i][j] != 0)
                    max = Math.max(max, helper(grid, i, j));

        return max;
    }

    private int helper(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] <= 0)
            return 0;
        int k = grid[i][j];
        grid[i][j] *= -1;
        int[] t = new int[4];
        t[0] = helper(grid, i - 1, j);
        t[1] = helper(grid, i + 1, j);
        t[2] = helper(grid, i, j - 1);
        t[3] = helper(grid, i, j + 1);
        grid[i][j] *= -1;
        return k + Arrays.stream(t).max().getAsInt();
    }
}

