package solutions;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * 
 * Referenct to https://leetcode.com/discuss/71169/java-2d-binary-indexed-tree-solution-clean-and-short-17ms
 * @author Zhiyuan
 *
 */

public class NumMatrixII {
	
	int[][] tree;
	int[][] nums;
	int rowNum;
	int colNum;
	
	public NumMatrixII(int[][] matrix) {
        if( matrix.length == 0 || matrix[0].length == 0 ){
        	return;
        }
        
        rowNum = matrix.length;
        colNum = matrix[0].length;
        
        tree = new int[rowNum+1][colNum+1];
        nums = new int[rowNum][colNum];
        
        for(int i = 0; i < rowNum; i++ ){
        	for(int j = 0; j < colNum; j++){
        		update(i,j, matrix[i][j]);
        	}
        }
    }

    public void update(int row, int col, int val) {
        if( rowNum == 0 || colNum == 0 ){
        	return;
        }
        
        int delta = val - nums[ row ][ col ];
        for(int i = row + 1; i <= rowNum; i += i &(-i) ){
        	for(int j = col + 1; j <= colNum; j += j & (-j) ){
        		tree[i][j] += delta;
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if( rowNum == 0 || colNum == 0 ){
        	return 0;
        }
        
        return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
    }
    
    private int sum(int row, int col){
    	int sum = 0;
    	for(int i = row; i > 0; i-=i&(-i)){
    		for(int j = col; j > 0; j -= j &(-j) ){
    			sum += tree[i][j];
    		}
    	}
    	return sum;
    }
}
