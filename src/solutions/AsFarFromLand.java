package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1162 As Far from Land as Possible
 */
public class AsFarFromLand {
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};

    public int maxDistance(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        if(queue.isEmpty() || queue.size() == row * col) {
            return -1;
        }

        int dist = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                grid[cur[0]][cur[1]] = Math.max(dist, grid[cur[0]][cur[1]]);

                for(int j = 0; j < dx.length; j++) {
                    int newX = cur[0] + dx[j];
                    int newY = cur[1] + dy[j];

                    if(newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == 0 && !visited[newX][newY]) {
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }

            dist++;
        }

        return dist - 2;
    }
}
