package solutions;

import java.util.Comparator;

public class Divide {
	
	public int divide(int dividend, int divisor) {

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long ans = 0;

        while (a >= b) {
            long shift = b, power = 1;
            while( (shift << 1 ) <= a ){
                shift <<= 1;
                power <<= 1;
            }
                ans += power;
                a -= shift;
        }

        if( (dividend>0) ^ (divisor>0)){
           ans = -ans; 
        }
       return ans>Integer.MAX_VALUE ? Integer.MAX_VALUE:(int)ans;
    }
}
