package solutions;

/**
 * 371 Sum of Two Integers
 */
public class SumOfTwoInt {
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
