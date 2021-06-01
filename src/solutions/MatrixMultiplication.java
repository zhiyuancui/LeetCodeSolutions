package solutions;

public class MatrixMultiplication {
	
	/**
	 * Given two sparse matrices A and B, return the result of AB.
	 * You may assume that A's column number is equal to B's row number.
	 * 
	 * Reference to : https://leetcode.com/discuss/71912/easiest-java-solution
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0|| A[0].length != B.length) {
            return new int[0][0];
        }


        int rowA = A.length;
        int colA = A[0].length;
        int rowB = B.length;
        int colB = B[0].length;

        int[][] result = new int[rowA][colB];

        for(int i = 0; i < rowA; i++) {
            for(int k = 0; k < colA; k++) {
                if(A[i][k] != 0) {
                    for(int j = 0; j < colB; j++) {
                        if(B[k][j] != 0) {
                            result[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }

        return result;
    }
}
