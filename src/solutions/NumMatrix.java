package solutions;

public class NumMatrix {

    private int[][] sumRegion;
    public NumMatrix(int[][] matrix) {
        if( matrix.length != 0 ){
            sumRegion = new int[matrix.length+1][matrix[0].length + 1];
        }
        
        for(int row = 0; row < matrix.length; row++){
            int sum = 0;
            for(int col = 0; col < matrix[0].length; col++){
                sum += matrix[row][col];
                sumRegion[row+1][col+1] = sum + sumRegion[row][col+1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion[ row2 + 1 ][ col2 + 1 ] - sumRegion[ row1 ][ col2 + 1 ] - sumRegion[ row2 + 1 ][ col1 ] + sumRegion[ row1 ][ col1 ];
    }
    
    public static void main(String[] args){
    	int[][] matrix = new int[5][5];
    	matrix[0][0] = 3;
    	matrix[0][1] = 0;
    	matrix[0][2] = 1;
    	matrix[0][3] = 4;
    	matrix[0][4] = 2;
    	matrix[1][0] = 5;
    	matrix[1][1] = 6;
    	matrix[1][2] = 3;
    	matrix[1][3] = 2;
    	matrix[1][4] = 1;
    	matrix[2][0] = 1;
    	matrix[2][1] = 2;
    	matrix[2][2] = 0;
    	matrix[2][3] = 1;
    	matrix[2][4] = 5;
    	matrix[3][0] = 4;
    	matrix[3][1] = 1;
    	matrix[3][2] = 0;
    	matrix[3][3] = 1;
    	matrix[3][4] = 7;
    	matrix[4][0] = 1;
    	matrix[4][1] = 0;
    	matrix[4][2] = 3;
    	matrix[4][3] = 0;
    	matrix[4][4] = 5;
    	NumMatrix n = new NumMatrix(matrix);
    }
}
