package solutions;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1970 Last Day Where You Can Still Cross
 */
public class LastDayToCross {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = cells.length, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canWalk(cells, row, col, mid)) {
                ans = mid; // Update current answer so far
                left = mid + 1; // Try to find a larger day
            } else right = mid - 1; // Try to find a smaller day
        }
        return ans;
    }
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    boolean canWalk(int[][] cells, int row, int col, int dayAt) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < dayAt; ++i) grid[cells[i][0]-1][cells[i][1]-1] = 1;
        Queue<int[]> bfs = new ArrayDeque<>();
        for (int c = 0; c < col; ++c) {
            if (grid[0][c] == 0) { // Add all valid start cells in the top row
                bfs.offer(new int[]{0, c});
                grid[0][c] = 1; // Mark as visited
            }
        }
        while (!bfs.isEmpty()) {
            int[] curr = bfs.poll();
            int r = curr[0], c  = curr[1];
            if (r == row - 1) return true; // Reached to bottom -> Return Valid
            for (int i = 0; i < 4; ++i) {
                int nr = r + DIR[i], nc = c + DIR[i+1];
                if (nr < 0 || nr == row || nc < 0 || nc == col || grid[nr][nc] == 1) continue;
                grid[nr][nc] = 1; // Mark as visited
                bfs.offer(new int[]{nr, nc});
            }
        }
        return false;
    }
}
