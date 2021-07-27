package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        int max = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1 && !visited[i][j]){
                    int count = countIsland(i, j, grid, visited);
                    max = Math.max(max, count);
                }
            }

        }
        return max;
    }

    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};

    private int countIsland(int x, int y, int[][] grid, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();

        int row = grid.length;
        int col = grid[0].length;

        visited[x][y] = true;
        queue.add(new int[]{x,y});

        int count = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            count++;

            visited[cur[0]][cur[1]] = true;

            for(int i = 0; i < dx.length; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];

                if(newX >= 0 && newX < row && newY >= 0 && newY < col && !visited[newX][newY] && grid[newX][newY] == 1) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }

        }

        return count;
    }
}
