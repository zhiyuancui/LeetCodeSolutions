package solutions.amazon;

import java.util.Arrays;
import java.util.Stack;

/**
 * Is Graph Bipartite
 */
public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        Arrays.fill(color, -1);

        for(int start = 0; start <n; start++) {
            if(color[start] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(start);
                color[start] = 0;

                while(!stack.isEmpty()) {
                    int cur = stack.pop();
                    for(int next: graph[cur]) {
                        if(color[next] == -1) {
                            stack.push(next);
                            color[next] = color[cur] ^ 1;
                        } else if(color[next] == color[cur]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
