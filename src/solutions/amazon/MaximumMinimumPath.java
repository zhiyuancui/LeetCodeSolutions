package solutions.amazon;

import java.util.PriorityQueue;

/**
 * 1102 Path With Maximum Minimum Value
 */
public class MaximumMinimumPath {
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};


    public int maximumMinimumPath(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        queue.offer(new int[]{0,0,grid[0][0]});

        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            if(cell[0] == row - 1 && cell[1] == col - 1) {
                return cell[2];
            }


            for(int i = 0; i < dx.length; i++) {
                int newX = dx[i] + cell[0];
                int newY = dy[i] + cell[1];

                if(newX >= 0 && newY >= 0 && newX < row && newY < col) {
                    int min = Math.min(dp[cell[0]][cell[1]], grid[newX][newY]);

                    if(min > dp[newX][newY]) {
                        dp[newX][newY] = min;
                        System.out.println("Added:"+newX+","+newY);
                        queue.offer(new int[]{newX, newY, dp[newX][newY]});
                    }
                }
            }
        }

        return dp[row-1][col-1];

    }
}
