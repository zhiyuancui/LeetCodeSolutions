package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 单源最短路径(从源点s到其它所有顶点v);
 * 有向图&无向图(无向图可以看作(u,v),(v,u)同属于边集E的有向图);
 * 边权可正可负(如有负权回路输出错误提示);
 */
public class Bellman {
    public void shortestPath(int[][] edges, int start) {
        HashMap<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        HashMap<Integer, Integer> dist = new HashMap<>();

        //build graph
        for(int[] edge: edges) {
            Map<Integer, Integer> map1 = graph.get(edge[0]);
            map1.put(edge[1], edge[2]);
            graph.put(edge[0], map1);
            dist.put(edge[0], Integer.MAX_VALUE);

            Map<Integer, Integer> map2 = graph.get(edge[1]);
            map1.put(edge[0], edge[2]);
            graph.put(edge[1], map2);
            dist.put(edge[1], Integer.MAX_VALUE);
        }

        dist.put(start, 0);

        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for(int i = 1; i < graph.size(); i++) {
            for(int[] edge: edges) {
                int src = edge[0];
                int des = edge[1];
                int cost = edge[2];

                if(dist.get(src) != Integer.MAX_VALUE && dist.get(src) + cost < dist.get(des)) {
                    dist.put(des, dist.get(src) + cost);
                }
            }
        }

        // Step 3: check for negative-weight cycles. The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        // path, then there is a cycle.
        for(int[] edge: edges) {
            int src = edge[0];
            int des = edge[1];
            int cost = edge[2];

            if(dist.get(src) != Integer.MAX_VALUE && dist.get(src) + cost < dist.get(des)) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
    }
}
