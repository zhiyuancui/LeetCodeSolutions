package solutions;

public class Divide {
	
	public int divide(int dividend, int divisor) {
        boolean neg = (dividend > 0 && divisor < 0) ||
            (dividend < 0 && divisor > 0);

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
	
	public static void main(String[] args){
		Divide d = new Divide();
		d.divide(14, 3);
	}
}
