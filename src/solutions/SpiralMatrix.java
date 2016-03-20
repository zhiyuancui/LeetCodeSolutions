package solutions;

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
}
