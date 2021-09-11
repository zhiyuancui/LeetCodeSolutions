package solutions;

import java.util.Arrays;

/**
 * 1135 Connecting Cities With Minimum Cost
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost/discuss/344867/Java-Kruskal's-Minimum-Spanning-Tree-Algorithm-with-Union-Find
 */
public class ConnectCities {
    public int minimumCost(int n, int[][] connections) {
        if(n <= 0 || connections == null || connections.length == 0) {
            return 0;
        }

        int[] roots = new int[n+1];

        for(int i = 0; i <= n; i++) {
            roots[i] = i;
        }

        Arrays.sort(connections, (a, b) -> a[2] - b[2]);

        int result = 0;

        for(int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];

            int root1 = find(roots, x);
            int root2 = find(roots, y);

            if(root1 != root2) {
                roots[root1] = root2;
                n--;
                result += connection[2];
            }

        }

        return n == 1 ? result : -1;

    }

    private int find(int[] roots, int id) {
        while(roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }

        return id;
    }
}
