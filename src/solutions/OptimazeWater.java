package solutions;

import java.util.*;

public class OptimazeWater {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        if(n <= 0) {
            return 0;
        }

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int i = 0; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] pipe : pipes) {
            graph.get(pipe[0]).add(new int[]{pipe[1], pipe[2]});
            graph.get(pipe[1]).add(new int[]{pipe[0], pipe[2]});
        }

        Set<Integer> visited = new HashSet<>();

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->{
            return a[2] - b[2];
        });

        for(int i = 0; i < wells.length; i++) {
            graph.get(0).add(new int[]{i+1, wells[i]});
            queue.offer(new int[]{0, i+1, wells[i]});
        }

        visited.add(0);

        int total = 0;
        while(!queue.isEmpty()) {
            if(visited.size() == n + 1) break;
            int[] cur = queue.poll();

            if(!visited.contains(cur[1])) {
                total += cur[2];
                visited.add(cur[1]);
                for(int[] next: graph.get(cur[1])) {
                    if(!visited.contains(next[0])) {
                        queue.offer(new int[]{cur[1], next[0], next[1]});
                    }
                }
            }
        }

        return total;
    }
}
