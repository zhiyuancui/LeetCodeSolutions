package solutions;

/**
 * 1718 Construct the Lexicographically Largest Valid Sequence
 */
public class ConstructLexicographicallyLargest {
    public int[] constructDistancedSequence(int n) {
        if(n < 1) {
            return new int[0];
        }

        int[] ans = new int[2*n - 1];

        boolean[] visited = new boolean[n+1];

        dfs(ans, 0, visited, n);

        return ans;
    }

    private boolean dfs(int[] ans, int idx, boolean[] visited, int n) {
        if(idx == ans.length) {
            return true;
        }

        if(ans[idx] != 0) {
            return dfs(ans, idx + 1, visited,n);
        }

        for(int i = n; i >= 1; i--) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            ans[idx] = i;

            if(i == 1) {
                if(dfs(ans, idx + 1, visited, n)) {
                    return true;
                }
            } else if(idx + i < ans.length && ans[idx + i] == 0) {
                ans[i+idx] = i;
                if(dfs(ans, idx + 1, visited, n)) {
                    return true;
                }
                ans[i+idx] = 0;
            }
            ans[idx] = 0;
            visited[i] = false;
        }

        return false;
    }
}
