package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeDiameter {
    int res;
    public int treeDiameter(int[][] edges) {
        if(edges == null || edges.length == 0) {
            return 0;
        }

        int n = edges.length + 1;

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges) {
            List<Integer> list1 = graph.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> list2 = graph.getOrDefault(edge[1], new ArrayList<>());

            list1.add(edge[1]);
            list2.add(edge[0]);

            graph.put(edge[0], list1);
            graph.put(edge[1], list2);
        }

        res = 0;
        dfs(graph, 0, -1);

        return res;
    }

    public int dfs(Map<Integer, List<Integer>> graph, int node, int parent) {
        int max1 = 0;
        int max2 = 0;

        for(int next: graph.get(node)) {
            if(next == parent) {
                continue;
            }

            int child = dfs(graph, next,node);
            if(child > max1) {
                max2 = max1;
                max1 = child;
            } else if(child > max2) {
                max2 = child;
            }
        }

        res = Math.max(res, max1+max2);

        return max1 + 1;
    }
}
