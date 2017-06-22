package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
	
	public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n || 
                    matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }
        
        return matrix;
    }
    
    
	
	int[] dx = {0,0,1,-1};
	int[] dy = {1,-1,0,0,};
	/**
	 * Alternate approach but cause TLE
	 * @param matrix
	 * @return
	 */
	public int[][] updateMatrix2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    update(matrix,i,j,row, col, 0);
                }
            }
        }
        
        return matrix;
    }
    
    private void update(int[][] matrix, int x, int y, int row, int col, int distance) {
        matrix[x][y] = distance;
        
        for(int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if( newX > 0 && newX < row && newY > 0 && newY < col && matrix[newX][newY] > distance + 1) {
                update(matrix,x,y,row, col, distance+1);
            }
        }
    }
}
