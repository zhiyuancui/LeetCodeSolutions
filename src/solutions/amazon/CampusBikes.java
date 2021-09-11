package solutions.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 1057 Campus Bikes
 */
public class CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) ->{
            if(a.distance == b.distance) {
                if(a.worker == b.worker) {
                    return a.bike - b.bike;
                } else {
                    return a.worker - b.worker;
                }
            } else {
                return a.distance - b.distance;
            }
        });

        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < workers.length; i++) {
            helper(workers[i], i, bikes, visited, queue);
        }

        int[] result = new int[workers.length];

        Arrays.fill(result, -1);

        Set<Integer> bikeSet = new HashSet<>();

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(visited.contains(cur.bike)) {
                helper(workers[cur.worker], cur.worker, bikes, visited, queue);
            } else {
                result[cur.worker] = cur.bike;
                visited.add(cur.bike);
            }
        }

        return result;
    }

    private void helper(int[] worker, int idx, int[][] bikes, Set<Integer> visited, PriorityQueue<Node> queue) {
        int min = Integer.MAX_VALUE;

        int bike = 0;

        for(int i = 0; i < bikes.length; i++) {
            if(!visited.contains(i)) {
                int dist = Math.abs(worker[0] - bikes[i][0]) + Math.abs(worker[1] - bikes[i][1]);

                if(min > dist) {
                    min = dist;
                    bike = i;
                }
            }
        }

        queue.add(new Node(min, idx, bike));
    }

    class Node {
        int distance;
        int worker;
        int bike;

        public Node(int distance, int worker, int bike) {
            this.distance = distance;
            this.worker = worker;
            this.bike = bike;
        }
    }
}
