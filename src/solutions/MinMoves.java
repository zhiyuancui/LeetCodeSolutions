package solutions;

import java.util.Arrays;

public class MinMoves {

	/**
	 * Minumum Moves to Equal Array Elements II
	 * 
	 * @param nums
	 * @return
	 */
	public int minMoves2(int[] nums) {
        Arrays.sort( nums );
        int len = nums.length;
        
        int moves = 0;
        for(int num : nums) {
            moves += Math.abs( num - nums[ len / 2 ]);
        }
        
        return moves;
    }
	
	/**
	 * Minimum Moves to Equal Array Elements
	 */
	public int minMoves(int[] nums) {
	        if( nums.length == 0 ) return 0;
	        int min = nums[0];
	        
	        for(int n : nums) {
	            min = Math.min(min,n);
	        }
	        
	        int res = 0;
	        for(int n: nums) {
	            res += n - min;
	        }
	        
	        return res;
    }
}
