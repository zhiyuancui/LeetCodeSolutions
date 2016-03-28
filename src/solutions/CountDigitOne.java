package solutions;

public class CountDigitOne {
	public int countDigitOne(int n) {
        if( n <= 0 ){
            return 0;
        }
        
        int q = n, x = 1, result = 0;
        
        do{
            int digit = q % 10;
            q = q / 10;
            result += q * x;
            if( digit == 1 ){
                result += n % x + 1;
            }
            
            if( digit > 1 ){
                result += x;
            }
            
            x = x * 10;
        }while( q > 0 );
        
        return result;
    }
}
