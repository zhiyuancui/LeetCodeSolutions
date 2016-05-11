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
		int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] result = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        if (B[k][j] != 0) result[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return result;   
    }
}
