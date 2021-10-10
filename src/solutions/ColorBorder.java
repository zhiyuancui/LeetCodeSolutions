package solutions;

/**
 * 1034 Coloring A Border
 */
public class ColorBorder {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if(grid == null || grid.length == 0)
            return null;
        int oldColor = grid[r0][c0];
        dfs(grid, r0, c0, oldColor);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] < 0)
                    grid[i][j] = color;
            }
        }
        return grid;
    }
    public void dfs(int[][] grid, int i, int j, int oldColor) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != oldColor)
            return;
        grid[i][j] = -oldColor;
        dfs(grid, i+1, j, oldColor);
        dfs(grid, i-1, j, oldColor);
        dfs(grid, i, j+1, oldColor);
        dfs(grid, i, j-1, oldColor);
        if(i > 0 && j > 0 && i < grid.length-1 && j < grid[0].length-1
                && oldColor == Math.abs(grid[i+1][j])
                && oldColor == Math.abs(grid[i-1][j])
                && oldColor == Math.abs(grid[i][j+1])
                && oldColor == Math.abs(grid[i][j-1]))
            grid[i][j] = oldColor;
    }
}
