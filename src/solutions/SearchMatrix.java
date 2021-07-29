package solutions;

public class SearchMatrix {

    /**
     * 240 Search a 2D Matrix II
     * 74 Search a 2D Matrix
     * @param matrix
     * @param target
     * @return
     */
	public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix == null || matrix.length == 0 ) {
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int x = 0;
        int y = col - 1;
        
        while( x < row && y >= 0 )
        {
            if( target == matrix[ x ][ y ] )
            {
                return true;
            }
            else if( target > matrix[ x ][ y ] )
            {
                x++;
            }
            else
            {
                y--;
            }
        }
        
        return false;
    }
	
	
	/**
	 * [
	 *	  [1,   3,  5,  7],
	 *	  [10, 11, 16, 20],
	 *	  [23, 30, 34, 50]
	 *	]
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix2(int[][] matrix, int target) {
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ){
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int start = 0;
        int end = row * col;
        
        while( start < end ){
            int mid = start + ( end  - start ) / 2;
            
            int value = matrix[mid / col][ mid % col];
            if( value == target ){
                return true;
            }
            if( value < target ){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        
        return false;
    }
}
