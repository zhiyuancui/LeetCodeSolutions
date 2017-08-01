package solutions;

public class RangeAddition {
	
	/**
	 * Range Addition II
	 * @param m
	 * @param n
	 * @param ops
	 * @return
	 */
	 public int maxCount(int m, int n, int[][] ops) {
	        if( ops == null || ops.length == 0 ){
	            return m * n;
	        }
	        
	        int row = Integer.MAX_VALUE, col = Integer.MAX_VALUE;
	        
	        for(int[] operation: ops){
	            row = Math.min(row, operation[0]);
	            col = Math.min(col, operation[1]);
	        }
	        
	        return row * col;
	    }
	 
	 /**
	  * Assume you have an array of length n initialized with all 0's and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

Example:

Given:

    length = 5,
    updates = [
        [1,  3,  2],
        [2,  4,  3],
        [0,  2, -2]
    ]

Output:

    [-2, 0, 3, 5, 3]
	  * @param length
	  * @param updates
	  * @return
	  */
	 public int[] getModifiedArray(int length, int[][] updates) {
	        
	        if( length == 0 ) {
	            return new int[0];
	        }
	        
	        int[] result = new int[length];
	        
	        for(int[] opt : updates) {
	            for(int i = opt[0]; i <= opt[1]; i++) {
	                result[i] += opt[2];
	            }
	        }
	        
	        return result;
	    }
}
