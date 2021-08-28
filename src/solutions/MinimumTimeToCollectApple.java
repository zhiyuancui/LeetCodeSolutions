package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1443 Minimum Time to Collect All Apples in a Tree
 */
public class MinimumTimeToCollectApple {
    private int time = 0;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge: edges) {
            List<Integer> list1 = graph.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> list2 = graph.getOrDefault(edge[1], new ArrayList<>());

            list1.add(edge[1]);
            list2.add(edge[0]);

            graph.put(edge[0], list1);
            graph.put(edge[1], list2);
        }


        boolean[] visited = new boolean[n];

        getDistance(graph, 0, visited, hasApple);

        return time;
    }

    private boolean getDistance(Map<Integer, List<Integer>> graph, int root, boolean[] visited, List<Boolean> hasApple) {
        if(visited[root]) {
            return false;
        }

        boolean apple = hasApple.get(root);

        visited[root] = true;

        for(int next : graph.get(root)) {
            boolean hasAppleInChild = getDistance(graph, next, visited, hasApple);
            if(hasAppleInChild) {
                time += 2;
            }
            apple = apple || hasAppleInChild;
        }

        return apple;
    }

}
