package solutions;

public class MinPathSum {
	public int minPathSum(int[][] grid) {
        
        if( grid == null || grid.length == 0 || grid[0].length == 0 ){
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int[][] matrix = new int[ row ][ col ];
         
         matrix[0][0] = grid[0][0];
         
         for(int i = 1; i < row; i++){
             matrix[i][0] = matrix[i-1][0] + grid[i][0];
         }
         
         for(int i = 1; i < col; i++){
             matrix[0][i] = matrix[0][i-1] + grid[0][i];
         }
         
         for(int i = 1; i < row; i++){
             for(int j = 1; j < col; j++){
                 matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1]) + grid[i][j];
             }
         }
         
         return matrix[row-1][ col - 1];
         
    }
}
