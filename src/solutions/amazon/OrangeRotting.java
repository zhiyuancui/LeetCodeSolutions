package solutions.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994 Rotting Oranges
 */
class OrangeRotting {
    int[] dx = new int[]{0,0,-1,1};
    int[] dy = new int[]{1,-1,0,0};

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int count = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    count++;
                } else if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
            }
        }

        int steps = 0;

        while(count > 0 && !queue.isEmpty()) {
            steps++;
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for(int j = 0; j < dx.length; j++) {
                    int newX = cur[0] + dx[j];
                    int newY = cur[1] + dy[j];

                    if(newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        count--;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }

        if(count > 0) {
            return -1;
        } else {
            return steps;
        }
    }
}
