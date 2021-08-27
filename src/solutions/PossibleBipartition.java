package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 886 Possible Bipartition
 */
public class PossibleBipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colors = new int[n+1];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] dislike: dislikes) {
            List<Integer> list1 = graph.getOrDefault(dislike[0], new ArrayList<>());
            List<Integer> list2 = graph.getOrDefault(dislike[1], new ArrayList<>());

            list1.add(dislike[1]);
            list2.add(dislike[0]);

            graph.put(dislike[0], list1);
            graph.put(dislike[1], list2);
        }

        for(int i = 0; i < n; i++) {
            if(colors[i] != 0) {
                continue;
            }

            if(!isValid(graph, colors, 1, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValid(Map<Integer, List<Integer>> graph, int[] colors, int color, int cur) {
        if(colors[cur] != 0) {
            return colors[cur] == color;
        }
        colors[cur] = color;

        if(graph.containsKey(cur)) {
            for(int next : graph.get(cur)) {
                if(!isValid(graph, colors, -color, next)) {
                    return false;
                }
            }
        }

        return true;
    }
}
