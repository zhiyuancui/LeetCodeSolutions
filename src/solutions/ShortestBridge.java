package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 934 Shortest Bridge
 */
public class ShortestBridge {
    int[] dx = new int[]{0,0,-1,1};
    int[] dy = new int[]{1,-1,0,0};

    public int shortestBridge(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        boolean found = false;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1 && !found) {
                    found = true;
                    dfs(i,j,grid);
                }
                if(found && grid[i][j] == 1) {
                    queue.add(new int[]{i,j});
                }
            }
        }

        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if(grid[cur[0]][cur[1]] == 2) {
                    return steps-1;
                }
                grid[cur[0]][cur[1]] = 1;
                for(int j = 0; j < dx.length; j++) {
                    int newX = cur[0] + dx[j];
                    int newY = cur[1] + dy[j];

                    if(newX >= 0 && newY >= 0 && newX < row && newY < col && (grid[newX][newY] == 0 || grid[newX][newY] == 2)) {
                        grid[newX][newY] = grid[newX][newY] == 0 ? 1 : 2;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }

            steps++;
        }

        return steps;
    }

    private void dfs(int x, int y, int[][] grid) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 2 ||  grid[x][y] == 0) {
            return;
        }

        grid[x][y] = 2;

        for(int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            dfs(newX, newY, grid);
        }
    }
}
