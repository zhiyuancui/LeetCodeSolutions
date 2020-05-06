package solutions.amazon;

import java.util.*;

public class minKnightMoves {

    int[] dx = new int[]{-2,2,-2,2,1,1,-1,-1};
    int[] dy = new int[]{1,1,-1,-1,-2,2,-2,2};

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0));

        int min = 0;
        Set<String> visited = new HashSet<>();

        visited.add(0+","+0);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if(cur.x == x && cur.y == y) {
                    return min;
                }
                for(int j = 0; j < dx.length; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if(nx <= 300 && ny <= 300 && nx >= -4 && ny > -4 && !visited.contains(nx+","+ny)) {
                        visited.add(nx+","+ny);
                        queue.offer(new Node(nx,ny));
                    }
                }
            }
            min++;
        }

        return min;
    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
