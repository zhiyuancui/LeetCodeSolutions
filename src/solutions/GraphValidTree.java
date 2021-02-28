package solutions;

import java.util.*;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to check whether these edges make up a valid tree.
 * For example:
 * 
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * 
 * Reference to : https://leetcode.com/discuss/52563/ac-java-union-find-solution
 * 
 * @author Zhiyuan
 *
 */
public class GraphValidTree {

	public boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);

            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;

            // union
            nums[x] = y;
        }

        return edges.length == n - 1;
    }

    private int find(int[] root, int i) {
    	while( root[i] != -1 ) {
            i = root[i];   
        }
       
        return i;
    }

    public boolean validTree2(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge: edges) {
            List<Integer> next = graph.getOrDefault(edge[0], new ArrayList<>());
            next.add(edge[1]);
            graph.put(edge[0], next);

            next = graph.getOrDefault(edge[1], new ArrayList<>());
            next.add(edge[0]);
            graph.put(edge[1], next);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(0);
        visited.add(0);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.println("cur: " +cur);
            visited.add(cur);
            if(graph.containsKey(cur)){
                for(int next: graph.get(cur)) {
                    if(!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }

        return visited.size() == n;
    }
    
}
