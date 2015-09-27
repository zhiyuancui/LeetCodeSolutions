package solutions;

import java.util.HashSet;

public class IsHappy {
	
	public boolean isHappy(int n) {
        if( n <= 0 )
        {
            return false;
        }
        
        if( n == 1 )
        {
            return true;
        }
        
        HashSet<Integer> prev = new HashSet<Integer>();
        
        while( n > 0 )
        {
            int next = 0;
            int old = n;
            while( n > 0 )
            {
                int digit = n % 10;
                n = n / 10;
                next += digit * digit;
            }
            
            if( next == 1 )
            {
                return true;
            }
            if( prev.contains(next) )
            {
                return false;
            }
            
            n = next;
            prev.add(next);
        }
        
        return false;
    }
	
	public static void main(String[] args)
	{
		IsHappy is = new IsHappy();
		is.isHappy(2);
	}
}
