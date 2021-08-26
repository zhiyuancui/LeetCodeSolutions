package solutions;

/**
 * 461 Hamming Distance
 */
public class HammingDistance {

	public int hammingDistance(int x, int y) {
		
		if( x == y ){
			return 0;
		}

		return Integer.bitCount( x ^ y );
	}
}
