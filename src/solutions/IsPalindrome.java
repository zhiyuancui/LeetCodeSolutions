package solutions;

public class IsPalindrome {
    
	/**
	 * Determine whether an integer is a palindrome. 
	 * Do this without extra space.
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
        
		
        if( x < 0 )
        {
            return false;
        }
        
        if( x < 10 )
        {
            return true;
        }
        
        String number = Integer.toString(x);
        
        int front = 0;
        int end = number.length() - 1;
        
        while( front < end )
        {
            if( number.charAt(front) != number.charAt(end) )
            {
                return false;
            }
            else
            {
                front++;
                end--;
            }
            
        }
        
        return true;
    }
}
