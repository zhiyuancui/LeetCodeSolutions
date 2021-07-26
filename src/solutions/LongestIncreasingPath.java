package solutions;


/**
 * 329 Longest Increasing Path in a Matrix
 */
public class LongestIncreasingPath {
	public int longestIncreasingPath(int[][] matrix) {
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] path = new int[ row ][ col ];
        
        int len = 0;
        for(int i = 0; i < row; i++ ){
            for(int j = 0; j < col; j++){
                len = Math.max(dfs(matrix, Integer.MIN_VALUE,i,j, row, col, path), len);
            }    
        }
        
        return len;
    }
    
    private int dfs(int[][] matrix, int min, int x, int y, int row, int col, int[][] path ){
        if( x< 0 || y < 0 || x >= row || y >= col ){
            return 0;
        }
        
        if( matrix[x][y] <= min ){
            return 0;
        }
        
        if( path[x][y] != 0 ){
            return path[x][y];
        }
        
        min = matrix[x][y];
        int left = dfs( matrix, min, x, y-1,row, col, path) + 1;
        int right = dfs( matrix, min, x, y+1,row, col, path) + 1;
        int up = dfs( matrix, min, x-1, y,row, col, path) + 1;
        int down = dfs( matrix, min, x+1, y,row, col, path) + 1;
        
        
        int max = Math.max(left, Math.max(right, Math.max( up, down )));
        path[x][y] = max;
        return max;
    }
}
