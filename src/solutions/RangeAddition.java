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
}
