package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PossibleBipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(N < 1 || dislikes == null || dislikes.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> color = new HashMap<>();

        for(int[] edge : dislikes) {
            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            graph.put(edge[0], list);

            list = graph.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            graph.put(edge[1], list);
        }

        for(int node = 1; node <= N; node++) {
            if(!color.containsKey(node) && !dfs(node, 0, graph, color)) {
                return false;
            }
        }

        return true;
    }


    private boolean dfs(int node, int c, Map<Integer, List<Integer>> graph, Map<Integer, Integer> color) {
        if(color.containsKey(node)) {
            return color.get(node) == c;
        }

        color.put(node, c);
        if(graph.containsKey(node)){
            for(int next: graph.get(node)) {
                if(!dfs(next, c ^ 1, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
