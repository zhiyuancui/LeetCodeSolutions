package solutions;

public class MyPow {
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
        
        return neg ? 1/(t1*t1*t2): t1*t1*t2;
        
    }

	public static void main(String[] args)
	{
		MyPow m = new MyPow();
		
		m.myPow(34.00515, -3);
	}
}
