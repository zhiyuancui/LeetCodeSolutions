package solutions;

public class MaximumSquare {
	public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        
        int square[][] = new int[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if( i == 0 || j == 0 ){
                    square[i][j] = matrix[i][j] - '0';
                }else if( matrix[i][j] == '0' ){
                    square[i][j] = 0;
                }else{
                    square[i][j] = Math.min(square[i][j-1],Math.min(square[i-1][j], square[i-1][j-1])) + 1;
                }
                
                if( max < square[i][j]) {
                    max = square[i][j];
                }
            }
        }
        
        return max * max;
    }
}
