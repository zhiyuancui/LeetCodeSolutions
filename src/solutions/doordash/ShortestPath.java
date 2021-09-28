package solutions.doordash;

import java.util.*;

/**
 * https://www.1point3acres.com/bbs/thread-778790-1-1.html
 */
public class ShortestPath {
    public boolean[] shortestPath(int[][] roads, int start, int end) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int i = 0; i < roads.length; i++) {
            int[] road = roads[i];
            int from = road[0];
            int to = road[1];
            int weight = road[2];

            List<int[]> list = graph.getOrDefault(from, new ArrayList<>());
            list.add(new int[]{to, weight, i});

            List<int[]> list2 = graph.getOrDefault(from, new ArrayList<>());
            list2.add(new int[]{from, weight, i});

            graph.put(from, list);
            graph.put(to, list2);
        }

        Map<Integer, Integer> cost = new HashMap<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> cost.get(a) - cost.get(b));
        Set<Integer> visited = new HashSet<>();

        cost.put(start, 0);
        queue.add(start);

        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(cur == end) {
                min = Math.min(min, cost.get(cur));
                break;
            }

            visited.add(cur);

            for(int[] next: graph.get(cur)) {
                if(visited.contains(next[0])) {
                    int minCost = cost.getOrDefault(next[0], Integer.MAX_VALUE);
                    minCost = Math.min(minCost, cost.get(cur) + next[1]);
                    cost.put(next[0], minCost);
                    queue.offer(next[0]);
                }
            }
        }

        boolean[] result = new boolean[graph.size()];

        dfs(start, end, graph, min, result, new HashSet<>());
        return result;
    }

    private void dfs(int start, int end, Map<Integer, List<int[]>> graph, int weight, boolean[] result, Set<Integer> roads) {
        if(weight < 0) {
            return;
        }

        if(start == end) {
            for(int road: roads) {
                result[road] = true;
            }
        }


        for(int[] next: graph.get(start)) {
            if(!roads.contains(next[2])) {
                roads.add(next[2]);
                dfs(next[0], end, graph, weight - next[1], result, roads);
                roads.remove(next[2]);
            }
        }
    }
}
