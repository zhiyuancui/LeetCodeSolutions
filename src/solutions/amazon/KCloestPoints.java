package solutions.amazon;

import java.util.PriorityQueue;

public class KCloestPoints {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return getDistance(b[0], b[1]) - getDistance(a[0],a[1]);
        });

        for(int[] point : points) {
            queue.add(point);
            if(queue.size()>K) {
                queue.poll();
            }
        }

        int[][] result = new int[K][2];
        int count = 0;
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            result[count][0] = point[0];
            result[count][1] = point[1];
            count++;
        }

        return result;
    }

    private int getDistance(int x, int y) {
        return x*x + y*y;
    }
}
