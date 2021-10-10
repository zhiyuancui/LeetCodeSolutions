package solutions;

import java.util.*;

/**
 * 1168 Optimize Water Distribution in a Village
 */
public class OptimazeWater {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] pipe : pipes) {
            graph.get(pipe[0]).add(new int[]{pipe[1], pipe[2]});
            graph.get(pipe[1]).add(new int[]{pipe[0], pipe[2]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < wells.length; i++) {
            queue.add(new int[]{i + 1, wells[i]});
        }

        int size = 0;
        int total = 0;

        while (!queue.isEmpty() && size < n) {
            int[] cur = queue.poll();
            if (visited.contains(cur[0])) {
                continue;
            }
            visited.add(cur[0]);
            size++;
            total += cur[1];

            if (graph.containsKey(cur[0])) {
                for (int[] next : graph.get(cur[0])) {
                    if (!visited.contains(next[0])) {
                        queue.add(next);
                    }
                }
            }
        }

        return total;
    }

}