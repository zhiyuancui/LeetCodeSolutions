package solutions;

public class ReverseInteger {

public int reverse(int x) {
        
        boolean neg = false;
        
        if(x<0)
        {
            neg = true;
            x = -x;
        }
        
        int reverse = 0;
        while( x > 0 )
        {
            int digit = x % 10;
            x = x/10;
            int newX =  reverse * 10 + digit;
            if( (newX - digit ) / 10 == reverse )
            {
                reverse = newX;
            }
            else
            {
                return 0;
            }
        }
        
        return neg ? -reverse: reverse;
    }
}
