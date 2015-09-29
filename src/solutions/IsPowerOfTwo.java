package solutions;

public class IsPowerOfTwo {

	public boolean isPowerOfTwo(int n) {
	
        if( n <= 0 )
        {
            return false;
        }
        
        int count = 0; 
        
        
        for(int i = 0; i < 32; i++)
        {
            int digit = n >> i & 1;
            if( digit == 1 )
            {
                count++;
            }
        }
        
        return count == 1;
    }
}
