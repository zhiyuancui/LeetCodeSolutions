package solutions;

public class Sqrt {

public int mySqrt(int x) {
        
        long start = 0;
        long end = x;
        
        while( end >= start )
        {
            
            long mid = start + ( end - start ) / 2;
            
            if( mid * mid == x )
            {
                return (int)mid;
            }
            else if( mid * mid < x )
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        
        return (int)end;
    }
}
