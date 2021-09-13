package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1631 Path With Minimum Effort
 * https://leetcode-cn.com/problems/path-with-minimum-effort/solution/duo-tu-xiang-xi-fen-xi-jie-ti-si-lu-fen-7z89x/
 */
public class MinEffortPath {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        int len = row * col;

        Union u = new Union(len);

        int start = 0;
        int end = len - 1;

        List<Edge> edges = new ArrayList<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int cur = i * col + j;
                if(j - 1 >= 0) {
                    int left = cur - 1;
                    Edge e = new Edge(cur, left, Math.abs(heights[i][j]-heights[i][j-1]));
                    edges.add(e);
                }

                if(i - 1 >= 0) {
                    int up = (i-1)*col + j;
                    Edge e = new Edge(cur, up, Math.abs(heights[i][j] - heights[i-1][j]));
                    edges.add(e);
                }
            }
        }

        Collections.sort(edges, (a, b) -> a.value - b.value);

        int res = 0;

        int idx = 0;

        while(u.find(start) != u.find(end)) {
            Edge edge = edges.get(idx);
            idx++;

            u.union(edge.i, edge.j);
            res = edge.value;
        }

        return res;
    }

    class Edge {
        int i;
        int j;
        int value;

        public Edge(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }

    class Union {
        int total;
        int count;
        int[] roots;
        int[] size;

        public Union(int n) {
            this.total = n;
            this.count = n;
            this.roots = new int[n];

            for(int i = 0; i < roots.length; i++) {
                roots[i] = i;
            }
        }

        public int find(int idx) {
            while(idx != roots[idx]) {
                idx = roots[idx];
            }
            return idx;
        }

        public void union(int i, int j) {
            int root1 = find(i);
            int root2 = find(j);

            if(root1 != root2) {
                roots[root1] = root2;
                count--;
            }
        }
    }
}
