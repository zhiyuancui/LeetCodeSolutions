package solutions;

import java.util.*;

/**
 * 743 Network Delay Time
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int max = 0;

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for(int[] time: times) {
            Map<Integer, Integer> map = graph.getOrDefault(time[0], new HashMap<Integer, Integer>());
            map.put(time[1], time[2]);
            graph.put(time[0], map);
        }

        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(k,0);

        Set<Integer> visited = new HashSet<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> dist.get(a) - dist.get(b));
        queue.add(k);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            max = Math.max(max, dist.get(cur));

            if(visited.contains(cur)) {
                continue;
            }
            visited.add(cur);

            if(graph.containsKey(cur)) {
                for(int next: graph.get(cur).keySet()) {
                    int min = dist.getOrDefault(next, Integer.MAX_VALUE);
                    min = Math.min(min, dist.get(cur) + graph.get(cur).get(next));

                    dist.put(next, min);
                    queue.add(next);
                }
            }
        }

        return dist.size() == n ? max : -1;
    }
}
