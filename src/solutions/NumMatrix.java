package solutions;

public class NumMatrix {

    private int[][] sumRegion;
    public NumMatrix(int[][] matrix) {
        if( matrix.length != 0 ){
            sumRegion = new int[matrix.length+1][matrix[0].length + 1];
        }
        
        for(int i = 0; i < matrix.length; i++){
            int sum = 0;
            for(int j = 0; j < matrix[0].length; j++){
                sum += matrix[i][j];
                sumRegion[i+1][j+1] = sum + sumRegion[i][j+1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion[ row2 + 1 ][ col2 + 1 ] - sumRegion[ row1 ][ col2 + 1 ] - sumRegion[ row2 + 1 ][ col1 ] + sumRegion[ row1 ][ col1 ];
    }
}
