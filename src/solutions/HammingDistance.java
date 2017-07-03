package solutions;

public class HammingDistance {

	public int hammingDistance(int x, int y) {
		
		if( x == y ){
			return 0;
		}

		return Integer.bitCount( x ^ y );
	}
	
	/**
	 * Total Hamming Distance
	 * @param nums
	 * @return
	 */
	public int totalHammingDistance(int[] nums) {
        
		int total = 0, n = nums.length;
	    for (int j=0;j<32;j++) {
	        int bitCount = 0;
	        for (int i=0;i<n;i++) 
	            bitCount += (nums[i] >> j) & 1;
	        total += bitCount*(n - bitCount);
	    }
	    return total;
    }
}
