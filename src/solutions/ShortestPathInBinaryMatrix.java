package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091 Shortest Path in Binary Matrix
 */
public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ans = 0;

        int[] dx = new int[]{0,0,1,-1,1,-1,1,-1};
        int[] dy = new int[]{1,-1,0,0,1,1,-1, -1};

        Queue<int[]> queue = new LinkedList<>();

        int row = grid.length;
        int col = grid[0].length;

        if(grid[0][0] == 1 || grid[row-1][col-1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[row][col];

        queue.add(new int[]{0,0});
        visited[0][0] = true;

        int len = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                //System.out.println("cur: (" + cur[0] +"," +cur[1]+")");
                if(cur[0] == row - 1 && cur[1] == col -1) {
                    return len + 1;
                }

                for(int j = 0; j < dx.length; j++) {
                    int x = cur[0] + dx[j];
                    int y = cur[1] + dy[j];

                    if(x >= 0 && y >= 0 && x < row && y < col && !visited[x][y] && grid[x][y] == 0) {
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            len++;
        }

        return -1;
    }
}
