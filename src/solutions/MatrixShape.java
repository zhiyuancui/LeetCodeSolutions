package solutions;

public class MatrixShape {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
        
        if( nums == null || nums.length == 0  ){
            return nums;
        }
        
        int row = nums.length;
        int column = nums[0].length;
        
        if( r*c != row * column ){
            return nums;
        }
        
        int[][] newMatrix = new int[r][c];
        int count = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                newMatrix[count/c][count%c] = nums[i][j];
                count++;
            }
        }
        
        return newMatrix;
    }
    
}
