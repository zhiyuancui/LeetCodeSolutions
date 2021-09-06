package solutions;

import java.util.*;

/**
 * 1168 Optimize Water Distribution in a Village
 */
public class OptimazeWater {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int i = 0; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] pipe : pipes) {
            graph.get(pipe[0]).add(new int[]{pipe[1], pipe[2]});
            graph.get(pipe[1]).add(new int[]{pipe[0], pipe[2]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < wells.length; i++) {
            queue.add(new int[]{i+1, wells[i]});
        }

        int size = 0;
        int total = 0;

        while(!queue.isEmpty() && size < n) {
            int[] cur = queue.poll();
            if(visited.contains(cur[0])) {
                continue;
            }
            visited.add(cur[0]);
            size++;
            total += cur[1];

            if(graph.containsKey(cur[0])) {
                for(int[] next: graph.get(cur[0])) {
                    if(!visited.contains(next[0])) {
                        queue.add(next);
                    }
                }
            }
        }

        return total;
    }

//    int[] parent;
//    int[] rank;
//    UnionFind(int n) {
//        parent = new int[n + 1];
//        rank = new int[n + 1];
//        for (int i = 0; i <= n; i++) {
//            parent[i] = i;
//        }
//        Arrays.fill(rank, 1);
//    }
//
//    int find(int num) {
//        if (num == parent[num]) return num;
//        return parent[num] = find(parent[num]);
//    }
//
//    boolean union(int n1, int n2) {
//        int root1 = find(n1);
//        int root2 = find(n2);
//        if (root1 == root2) return false;
//        if (rank[root1] > rank[root2]) {
//            parent[root2] = root1;
//        } else if (rank[root1] < rank[root2]) {
//            parent[root1] = root2;
//        } else {
//            parent[root2] = root1;
//            rank[root1] += 1;
//        }
//        return true;
//    }
//}
//
//class Solution {
//    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
//
//        int[][] allEdges = new int[n + pipes.length][3];
//        int i = 0;
//        for (int cost: wells) {
//            allEdges[i] = new int[]{0, i + 1, cost};
//            i++;
//        }
//        for (int[] pipe: pipes) {
//            allEdges[i] = pipe;
//            i++;
//        }
//
//        Arrays.sort(allEdges, ((a, b) -> a[2] - b[2]));
//        UnionFind uf = new UnionFind(n);
//        int totalCost = 0;
//        for (int[] pipe : allEdges) {
//            if (uf.union(pipe[0], pipe[1])) {
//                totalCost += pipe[2];
//            }
//        }
//        return totalCost;
//    }
}
