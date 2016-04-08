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
	
	public static void main(String[] args){
		MaximumSquare m = new MaximumSquare();
		char[][] matrix = new char[4][5];
		matrix[0][0] = '1';
		matrix[0][1] = '0';
		matrix[0][2] = '1';
		matrix[0][3] = '0';
		matrix[0][4] = '0';
		matrix[1][0] = '1';
		matrix[1][1] = '0';
		matrix[1][2] = '1';
		matrix[1][3] = '1';
		matrix[1][4] = '1';
		matrix[2][0] = '1';
		matrix[2][1] = '1';
		matrix[2][2] = '1';
		matrix[2][3] = '0';
		matrix[2][4] = '1';
		matrix[3][0] = '1';
		matrix[3][1] = '0';
		matrix[3][2] = '0';
		matrix[3][3] = '1';
		matrix[3][4] = '0';
		m.maximalSquare(matrix);
	}
}
