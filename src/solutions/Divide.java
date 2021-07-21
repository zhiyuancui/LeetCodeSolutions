package solutions;

/**
 * 29 Divide Two Integers
 */
public class Divide {
	
	public int divide(int dividend, int divisor) {

		long a = dividend;
        long b = divisor;
        
        long ans = 0;
        
        boolean isneg = false;
        if( a < 0 ) {
            a = -a;
            isneg = !isneg;
        }
        
        if( b < 0 ) {
            b = -b;
            isneg = !isneg;
        }
        
        
        while( b <= a ){
            long shift = b, power = 1;
            while( (shift<<1) <= a) {
                shift <<= 1;
                power <<= 1;
            }
            
            a -= shift;
            ans += power;
        }
        
        if( isneg ) {
            ans = -ans;
        }
        
        return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)ans;
    }
}
