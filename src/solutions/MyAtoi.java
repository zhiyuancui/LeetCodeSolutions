package solutions;

import java.util.ArrayList;
import java.util.Queue;

public class MyAtoi {
	public int myAtoi(String str) {
		str = str.trim();
        
        if( str == null || str.length() == 0 )
        {
            return 0;
        }
        
        
        boolean neg = false;
        if( str.charAt(0) == '+' || str.charAt(0) == '-' )
        {
            if( str.charAt(0) == '-' )
            {
                neg = true;
            }
            
            str = str.substring(1);
        }
        
        int len = str.length();
        int result = 0;
        
        for( int i = 0; i < len; i++ )
        {
            if( str.charAt(i) <'0' || str.charAt(i) > '9')
            {
                break;
            }
            int digit = str.charAt( i ) - '0';
            int next = result * 10 + digit;
            
            if( ( next - digit ) / 10 == result && next >= 0 )
            {
                result = next;
            }
            else
            {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        
        return neg ? -result : result;
    }
}
