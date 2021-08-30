package solutions;

/**
 * 1254 Number of Closed Islands
 */
public class ClosedIslands {
    boolean flag = true;

    public int closedIsland(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 0) {
                    dfs(grid, i, j);
                    if(flag) {
                        count++;
                    }
                    flag = true;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;

        if(x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 1) {
            return;
        }

        if((x == 0 || y == 0 || x == row - 1 || y == col - 1) && grid[x][y] == 0) {
            flag = false;
        }

        grid[x][y] = 1;

        dfs(grid, x-1, y);
        dfs(grid, x+1, y);
        dfs(grid, x, y-1);
        dfs(grid, x, y+1);
    }
}
