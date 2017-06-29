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
    
    
}
