package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 任意两点
 * 有负权
 * 无向图， 有环
 * https://juejin.cn/post/6844903833382944781
 * 邻接矩阵实现 https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 */
public class Floyd {
    public void floydWarshall(int[][] edges) {
        HashMap<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        HashMap<Integer, Integer> dist = new HashMap<>();

        //build graph
        for(int[] edge: edges) {
            Map<Integer, Integer> map1 = graph.get(edge[0]);
            map1.put(edge[1], edge[2]);
            graph.put(edge[0], map1);
            dist.put(edge[0], edge[2]);

            Map<Integer, Integer> map2 = graph.get(edge[1]);
            map1.put(edge[0], edge[2]);
            graph.put(edge[1], map2);
            dist.put(edge[1], edge[2]);
        }

        for(int k: graph.keySet()) {
            for(int i: graph.keySet()) {
                for(int j: graph.keySet()) {
                    int costik = graph.get(k).get(i);
                    int costkj = graph.get(k).get(j);
                    int costij = graph.get(i).get(j);

                    if(costik + costkj < costij) {
                        dist.put(i, costik + costkj);
                    }
                }
            }
        }

    }
}
