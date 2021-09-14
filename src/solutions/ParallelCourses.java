package solutions;

import java.util.*;

/**
 * 1136 Parallel Courses
 */
public class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        if( n <= 0 ) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n+1];

        for(int[] edge : relations) {
            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            indegree[edge[1]]++;
            graph.put(edge[0], list);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        int semester = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int cur = queue.poll();
                n--;
                if(graph.containsKey(cur)) {
                    for(int next: graph.get(cur)) {
                        indegree[next]--;
                        if(indegree[next] == 0) {
                            queue.offer(next);
                        }
                    }
                }
            }
            semester++;
        }

        return n == 0 ? semester : -1;
    }
}
