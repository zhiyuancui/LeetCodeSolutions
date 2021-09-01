package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 407 Trapping Rain Water II
 */
public class TrappingRainWaterII {
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};

    class Node {
        int x;
        int y;
        int height;
        public Node(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {

        int row = heightMap.length;
        int col = heightMap[0].length;

        PriorityQueue<Node> queue = new PriorityQueue<>((a,b) -> a.height - b.height);
        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < col; i++) {
            visited[0][i] = true;
            visited[row-1][i] = true;
            queue.add(new Node(0, i, heightMap[0][i]));
            queue.add(new Node(row-1, i, heightMap[row-1][i]));
        }

        for(int i = 0; i < row; i++) {
            visited[i][0] = true;
            visited[i][col-1] = true;
            queue.add(new Node(i, 0, heightMap[i][0]));
            queue.add(new Node(i, col-1, heightMap[i][col-1]));
        }

        int water = 0;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            visited[cur.x][cur.y] = true;
            for(int i = 0; i < dx.length; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if(newX >= 0 && newY >= 0 && newX < row && newY < col && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Node(newX, newY, Math.max(heightMap[newX][newY], cur.height)));
                    water += Math.max(0, cur.height - heightMap[newX][newY]);
                }
            }
        }

        return water;
    }
}
