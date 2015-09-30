package solutions;

public class SearchMatrix {

	/**
	 * Write an efficient algorithm that searches for a value 
	 * in an m x n matrix. 
	 * This matrix has the following properties:
	 * Integers in each row are sorted in ascending from left to right.
	 * Integers in each column are sorted in ascending from top to bottom.
	 * For example,
	 * Consider the following matrix:
	 * [
	 * [1,   4,  7, 11, 15],
	 * [2,   5,  8, 12, 19],
	 * [3,   6,  9, 16, 22],
	 * [10, 13, 14, 17, 24],
	 * [18, 21, 23, 26, 30]
	 * ]
	 * @param matrix
	 * @param target
	 * @return
	 */
	
	public boolean searchMatrix(int[][] matrix, int target) {
        
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
}
