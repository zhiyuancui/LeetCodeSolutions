package solutions;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SwimInRisingWater {
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};

    public int swimInWater(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        Set<Integer> visited = new HashSet<>();

        queue.add(new int[]{0,0});

        int max = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            max = Math.max(max, grid[cur[0]][cur[1]]);

            if(cur[0] == row - 1 && cur[1] == col -1) {
                return max;
            }
            visited.add(cur[0]*col+cur[1]);
            for(int i = 0; i < dx.length; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if(x >= 0 && y >= 0 && x < row && y < col && !visited.contains(x*col+y)) {
                    queue.add(new int[]{x,y});
                    visited.add(x*col+y);
                }
            }
        }

        return -1;
    }
}
