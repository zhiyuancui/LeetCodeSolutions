package solutions;

public class AddBinary {

	public String addBinary(String a, String b) {
        
        
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
     
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        while( len1 >= 0 || len2 >= 0 || carry != 0){    
            int val1 = len1 < 0 ? 0 : toInc(a.charAt( len1 ) );
            int val2 = len2 < 0 ? 0 : toInc(b.charAt( len2 ) );
        	
            int digit = val1 + val2 + carry;
            carry = digit / 2;
            digit = digit % 2;
            sb.insert(0, digit);
            len1--;
            len2--;
        }
      
        return sb.toString();
    }
    
    private int toInc( Character c )
    {
        return c - '0';
    }
    
}
