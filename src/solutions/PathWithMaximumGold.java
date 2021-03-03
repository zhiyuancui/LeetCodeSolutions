package solutions;

public class PathWithMaximumGold {
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
                    max = Math.max(max, getGold(grid, i, j, 0));
                }
            }
        }

        return max;
    }

    private int getGold(int[][] grid, int x, int y, int prev) {
        int row = grid.length;
        int col = grid[0].length;

        if( x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) {
            return prev;
        }

        int cur = grid[x][y];
        prev += grid[x][y];
        grid[x][y] = 0;

        int max = 0;
        max = Math.max(max, getGold(grid, x+1, y, prev));
        max = Math.max(max, getGold(grid, x-1, y, prev));
        max = Math.max(max, getGold(grid, x, y+1, prev));
        max = Math.max(max, getGold(grid, x, y-1, prev));

        grid[x][y] = cur;

        return max;
    }
}
