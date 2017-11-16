package solutions;

import java.util.Arrays;

public class FindLongestChain {
	/**
	 * Maximum Length of Pair Chain
	 * @param pairs
	 * @return
	 */
	public int findLongestChain(int[][] pairs) {
		 Arrays.sort(pairs, (p1,p2)->p1[1]-p2[1] );

	        int count = 0, end = Integer.MIN_VALUE;
	        for (int[] pair : pairs)
	        {
	            if (pair[0] > end)
	            {
	                count++;
	                end = pair[1];
	            }
	        }
	        return count;
    }
}
