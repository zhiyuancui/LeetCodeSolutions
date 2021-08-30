package solutions;

import java.util.*;

/**
 * 310 Minimum Height Tree
 */
public class MinHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if( n == 1 ){
            result.add(0);
            return result;
        }

        int[] degree = new int[n];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges) {
            List<Integer> next = graph.getOrDefault(edge[0], new ArrayList<>());
            next.add(edge[1]);
            graph.put(edge[0], next);

            next = graph.getOrDefault(edge[1], new ArrayList<>());
            next.add(edge[0]);
            graph.put(edge[1], next);

            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < degree.length; i++) {
            if(degree[i] == 1) {
                queue.add(i);
            } else if(degree[i] == 0) {
                return new ArrayList<>();
            }
        }

        while(!queue.isEmpty()) {
            result = new ArrayList<>();
            int size = queue.size();

            for(int j = 0; j < size; j++) {
                int cur = queue.poll();
                result.add(cur);
                degree[cur]--;

                for(int next: graph.get(cur)) {
                    if(degree[next] == 0) {
                        continue;
                    } else if(degree[next] == 2) {
                        queue.offer(next);
                    }

                    degree[next]--;
                }
            }
        }

        return result;
    }
}
