package solutions.amazon.oa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Zoombie in Matrix
 * Time Complexity: O(N), where N is the number of cells in the grid
 * Space Complexity: O(N)
 * BFS
 */
public class RottenOranges {
    int[] dx =  new int[]{0,0,1,-1};
    int[] dy =  new int[]{1,-1,0,0};

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            if(fresh == 0) {
                return count;
            }
            count++;
            for(int i =0; i < size; i++) {
                int[] cur = queue.poll();
                for(int j = 0; j < dx.length; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];
                    if(nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 1) {
                        fresh--;
                        grid[nx][ny] = 2;
                        queue.add(new int[]{nx,ny});
                    }

                }
            }
        }
        return fresh == 0 ? count: -1;
    }
}

