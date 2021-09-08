package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 847 Shortest Path Visiting All Nodes
 */
public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        if(graph == null || graph.length == 0 || graph[0].length == 0) {
            return 0;
        }

        int ans = (1 << graph.length ) - 1;

        int[][] visitedMap = new int[graph.length][ans+1];

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < graph.length; i++) {
            queue.add(new int[]{i, 1 << i});
        }

        int shortestPath = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            shortestPath++;
            for(int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int node = cur[0];
                int visited = cur[1];

                for(int next: graph[node]) {
                    int newVisited = visited | (1 << next);
                    if(visitedMap[next][newVisited] == 1) {
                        continue;
                    }
                    visitedMap[next][newVisited] = 1;
                    if(newVisited == ans) {
                        return shortestPath;
                    }
                    queue.add(new int[]{next, newVisited});
                }
            }
        }

        return -1;

    }
}
