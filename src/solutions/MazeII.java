package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MazeII {
    int[] dx = new int[]{0,0,-1,1};
    int[] dy = new int[]{1,-1,0,0};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) {
            return 0;
        }

        int row = maze.length;
        int col = maze[0].length;

        int[][] count = new int[row][col];
        for(int[] c : count) {
            Arrays.fill(c, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> count[a[0]][a[1]] - count[b[0]][b[1]]);

        queue.offer(start);
        count[start[0]][start[1]] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == destination[0] && cur[1] == destination[1]) {
                return count[cur[0]][cur[1]];
            }

            for(int i = 0; i < dx.length; i++) {
                int newX = cur[0];
                int newY = cur[1];
                int step = 0;

                while(newX >= 0 && newY >= 0 && newX < row && newY < col && maze[newX][newY] != 1) {
                    newX += dx[i];
                    newY += dy[i];
                    step++;
                }

                newX -= dx[i];
                newY -= dy[i];
                step--;

                if(count[cur[0]][cur[1]] + step < count[newX][newY]) {
                    queue.offer(new int[]{newX, newY});
                    count[newX][newY] = count[cur[0]][cur[1]] + step;
                }
            }
        }

        return -1;
    }
}
