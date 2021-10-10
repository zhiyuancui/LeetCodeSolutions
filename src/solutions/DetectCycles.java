package solutions;

/**
 * 1559 Detect Cycles in 2D Grid
 */
public class DetectCycles {
    public boolean containsCycle(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[] roots = new int[row * col];
        for(int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                char cur = grid[i][j];

                if(j+1 < col && cur == grid[i][j+1]) {
                    if(union(roots, i, j, i, j +1, col)) {
                        return true;
                    }
                }

                if(i+1 < row && cur == grid[i+1][j]) {
                    if(union(roots, i, j, i+1, j, col)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean union(int[] roots, int x1, int y1, int x2, int y2, int col) {
        int root1 = x1* col + y1;
        int root2 = x2*col + y2;

        int parent1 = find(roots, root1);
        int parent2 = find(roots, root2);

        if(parent1 == parent2) {
            return true;
        }

        if(parent1 < parent2) {
            roots[parent2] = parent1;
        } else {
            roots[parent1] = parent2;
        }

        return false;
    }

    private int find(int[] roots, int idx) {
        while(roots[idx] != idx) {
            roots[idx] = roots[roots[idx]];
            idx = roots[idx];
        }
        return idx;
    }
}
