/**
 * Given a non-negative integer num, 
 * repeatedly add all its digits until the result has only one digit.
 * For example:Given num = 38, 
 * the process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 */

package solutions;

public class AddDigits {
	
	public int addDigits(int num) {
	        
	        
	        if( num < 0 )
	        {
	            return 0;
	        }
	        
	        int next = num;
	        
	        while( next >= 10 ){
	            int n = next;
	            next = 0;
	            while( n > 0 )
	            {
	                int digit = n % 10;
	                n = n / 10;
	                next += digit;
	            }
	        }
	        
	        return next;
	    }
	
	public int addDigits2(int num){
		return num!=0?(num%9!=0?num%9:9):0;
	}
}
