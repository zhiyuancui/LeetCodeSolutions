package solutions;

public class ShortestBridge {
    public void dfs(int a[][], int i, int j) {
        if (i < 0 || i >= a.length || j < 0 ||  j >= a[0].length || a[i][j] == 0 || a[i][j] == 2) return;
        a[i][j] = 2;
        dfs(a,i-1,j);dfs(a,i+1,j);dfs(a,i,j-1);dfs(a,i,j+1);
    }
    public int shortestBridge(int[][] a) {
        boolean found = false;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1 && !found) {
                    found = true;
                    dfs(a,i,j);
                }
                if (found && a[i][j] == 1) q.add(new int[]{i,j});
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int c = 0; c < size; c++) {
                int b[] = q.remove();
                int i = b[0];
                int j = b[1];
                if ((i > 0 && a[i-1][j] == 2) || (i < a.length-1 && a[i+1][j] == 2) || (j > 0 && a[i][j-1] == 2) ||
                        (j < a[0].length-1 && a[i][j+1] == 2)) return ans;
                if (i > 0 && a[i-1][j] == 0) {
                    a[i-1][j] = 1;
                    q.add(new int[]{i-1,j});
                }
                if (i < a.length-1 && a[i+1][j] == 0) {
                    a[i+1][j] = 1;
                    q.add(new int[]{i+1,j});
                }
                if (j > 0 && a[i][j-1] == 0) {
                    a[i][j-1] = 1;
                    q.add(new int[]{i,j-1});
                }
                if (j < a[0].length-1 && a[i][j+1] == 0) {
                    a[i][j+1] = 1;
                    q.add(new int[]{i,j+1});
                }
            }
            ans++;
        }
        return 0;
    }
}
