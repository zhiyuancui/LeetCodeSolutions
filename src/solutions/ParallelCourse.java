package solutions;

import java.util.*;

public class ParallelCourse {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        if( n <= 0 || k <= 0) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];

        for(int[] edge : dependencies) {
            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            indegree[edge[1]]++;
            outdegree[edge[0]]++;
            graph.put(edge[0], list);
        }

        for(int i = 1; i < indegree.length; i++) {
            System.out.println(i+" indegree: " + indegree[i]+"  outdegree: " + outdegree[i]);
        }


        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> outdegree[b] - outdegree[a]);

        int count = 0;

        for(int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nextLevel = new ArrayList<>();
            System.out.println("///////////////////////////");
            for(int i = 0; i < Math.min(size,k); i++) {
                int cur = queue.poll();
                System.out.println(cur);
                if(graph.containsKey(cur)) {
                    for(int next : graph.get(cur)) {
                        indegree[next]--;
                        if(indegree[next] == 0) {
                            nextLevel.add(next);
                        }
                    }
                }
            }
            queue.addAll(nextLevel);
            count++;
        }

        return count;
    }
}
