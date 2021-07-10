package solutions.amazon;

import java.util.Arrays;

public class GetMaximumGold {
    public int getMaximumGold(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        int max = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] > 0) {
                    max = Math.max(max, dfs(grid, i, j, 0));
                }
            }
        }

        return max;
    }

    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};

    private int dfs(int[][] grid, int x, int y,  int prev) {

        int row = grid.length;
        int col = grid[0].length;

        if( x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) {
            return prev;
        }

        int cur = grid[x][y];
        prev += grid[x][y];
        grid[x][y] = 0;

        int max = 0;
        max = Math.max(max, dfs(grid, x+1, y, prev));
        max = Math.max(max, dfs(grid, x-1, y, prev));
        max = Math.max(max, dfs(grid, x, y+1, prev));
        max = Math.max(max, dfs(grid, x, y-1, prev));

        grid[x][y] = cur;

        return max;
    }
}

