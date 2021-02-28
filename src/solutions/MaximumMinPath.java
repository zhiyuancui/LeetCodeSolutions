package solutions;

import java.util.PriorityQueue;

public class MaximumMinPath {
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};

    public int maximumMinimumPath(int[][] A) {
        int row = A.length;
        int col = A[0].length;

        boolean[][] visited = new boolean[row][col];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        queue.offer(new int[]{0,0,A[0][0]});

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();

            if(cell[0] == row -1 && cell[1] == col - 1) {
                return cell[2];
            }

            visited[cell[0]][cell[1]] = true;

            for(int i = 0; i < dx.length; i++) {
                int newX = dx[i] + cell[0];
                int newY = dy[i] + cell[1];

                if(newX < 0 || newX >= row || newY < 0 || newY >= col || visited[newX][newY] ) {
                    continue;
                }

                int min = Math.min(cell[2], A[newX][newY]);
                queue.offer(new int[]{newX, newY, min});
            }

        }

        return -1;
    }
}
