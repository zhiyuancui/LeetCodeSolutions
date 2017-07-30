package solutions;

public class Pow {

	public double myPow(double x, int n) {
        
        if( n == 0 )
        {
            return 1;
        }
        
        if( n == 1 )
        {
            return x;
        }
        
        boolean neg = false;
        if( n < 0 )
        {
            neg = true;
            n = -n;
        }
        
        double t1 = myPow(x, n/2 );
        double t2 = myPow(x, n- (n/2)*2);
        
        if( neg ) {
            if( t1*t2*t1 == 0 ) {
                return 0;
            } else {
                return 1/(t1*t1*t2);
            }   
        } else {
            return t1*t1*t2;
        }
        
    }
	
	/**
	 * With n == Integer.MIN_VALUE
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow2(double x, int n) {
        return pow(x, n);
    }
    
    private double pow(double x, long n) {
        if (n == 0){
        	return 1;
        }
        if (n == 1){
        	return x;
        }
        if (n < 0){
        	return 1 / pow(x, 0 - n);
        }
        if (n % 2 == 0){
        	return pow(x * x, n / 2);
        }
        else{
        	return pow(x * x, n / 2) * x;
        }
    }
}
