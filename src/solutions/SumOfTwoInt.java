package solutions;

public class SumOfTwoInt {

	/**
	 * Reference to :https://discuss.leetcode.com/topic/49771/java-simple-easy-understand-solution-with-explanation
	 * https://discuss.leetcode.com/topic/50315/a-summary-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
	 * @param a
	 * @param b
	 * @return
	 */
	public int getSum(int a, int b) {
		if( a == 0 ) return b;
		if( b == 0 ) return a;
		
		while( b != 0 ) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
	}
}
