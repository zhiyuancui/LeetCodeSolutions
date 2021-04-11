package solutions;

public class CountDigitOne {
    //https://leetcode.com/problems/number-of-digit-one/discuss/64382/JavaPython-one-pass-solution-easy-to-understand
	//(1) xyz * 1000                     if d == 0
    //(2) xyz * 1000 + abc + 1           if d == 1 加1加的是xyz1000这种情况
    //(3) xyz * 1000 + 1000              if d > 1
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
