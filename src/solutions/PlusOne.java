package solutions;

public class PlusOne {

	public int[] plusOne(int[] digits) {
        
        int[] result = new int[ digits.length + 1 ];
        
        if( digits == null || digits.length == 0 )
        {
            return result;
        }
        
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i-- )
        {
            result[ i + 1 ] = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = result[i+1];
        }
        
        if( carry != 0 )
        {
            result[0] = carry;
            return result;
        }
        
        return digits;
    }
}
