package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 54 Spiral Matrix
 */
public class SpiralMatrix {
	public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if( n < 0 ){
            return result;
        }
        
        if( n == 1 ){
            result[0][0] = 1;
        }
        
        int count = 1;
        
        int row = n;
        int col = n;
        
        int startX = 0;
        int startY = 0;
        
        while( startX < n - 1 && startY < n - 1){
            
            //left
            for(int i = startY; i < col - startY; i++){
                result[startX][i] = count;
                count++;
            }
            
            
            //down
            for(int i = startX+1; i < row - startX; i++){
                result[i][col-startY - 1] = count;
                count++;
            }
            
            
            //right
            for(int i = col - startY - 2; i >= startY; i--){
                result[ row - startX - 1][i] = count;
                count++;
            }
            
            
            //up
            for(int i = row - startX - 2; i > startX; i-- ){
                result[i][ startY ] = count;
                count++;
            }
            
            startX++;
            startY++;
        }
        
        return result;
    }
	
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return result;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int startX = 0;
        int startY = 0;
        int count = 0;
        
        while( count < row * col){
            
            //left
            for(int i = startY; i < col - startY; i++){
                result.add( matrix[ startX ][ i ]);
                count++;
            }
            
            
            //down
            for(int i = startX+1; i < row - startX; i++){
                result.add( matrix[ i ][ col - startY - 1 ]);
                count++;
            }
            
            
            //right
            for(int i = col - startY - 2; i >= startY && count < row * col; i--){
                result.add( matrix[ row - startX - 1][i] );
                count++;
            }
            
            
            //up
            for(int i = row - startX - 2; i > startX && count < row * col; i-- ){
                result.add( matrix[i][ startY ] );
                count++;
            }
            
            startX++;
            startY++;
        }
        
        return result;
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        return null;
    }
}
