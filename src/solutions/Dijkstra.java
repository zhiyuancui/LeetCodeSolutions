package solutions;

import java.util.*;

public class Dijkstra {

    public void dijkstra(int[][] nodes, int src) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        Map<Integer, Integer> dist = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int[] edge : nodes) {
            Map<Integer, Integer> map = graph.getOrDefault(edge[0], new HashMap<>());
            map.put(edge[1], edge[2]);
            graph.put(edge[0], map);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> dist.get(a) - dist.get(b));
        dist.put(src, 0);
        queue.add(src);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : graph.get(cur).keySet()) {
                if(!visited.contains(next)) {
                    int min = dist.getOrDefault(next, Integer.MAX_VALUE);
                    min = Math.min(min, graph.get(cur).get(next));
                    dist.put(next, min);
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        for(int node: dist.keySet()) {
            System.out.println(node+ " : " + dist.get(node));
        }
    }

    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        int[][] edges = new int[6][3];
        edges[0][0] = 0;
        edges[0][1] = 1;
        edges[0][2] = 9;
        edges[1][0] = 0;
        edges[1][1] = 2;
        edges[1][2] = 6;
        edges[2][0] = 0;
        edges[2][1] = 3;
        edges[2][2] = 5;
        edges[3][0] = 0;
        edges[3][1] = 4;
        edges[3][2] = 3;
        edges[4][0] = 2;
        edges[4][1] = 1;
        edges[4][2] = 2;
        edges[5][0] = 2;
        edges[5][1] = 3;
        edges[5][2] = 4;


        d.dijkstra(edges,0);
    }
}
