package solutions;

/**
 * 48 Rotate Image
 */
public class RotateImage {
	
	public void rotate(int[][] matrix) {
        
        if( matrix == null  )
        {
            return;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0;
        int end = col - 1;
        while( start < end )
        {
            for(int i = 0; i < col; i++)
            {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
            }
            
            start++;
            end--;
        }


        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < i; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
    }
}
