package solutions;

public class AddBinary {

public String addBinary(String a, String b) {
        
        
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
     
        String result = "";
        int carry = 0;
        
        while( len1 >= 0 && len2 >= 0 ){    
            
            int digit = toInc(a.charAt( len1 ) ) + toInc(b.charAt( len2 ) ) + carry;
            carry = digit / 2;
            digit = digit % 2;
            result = digit + result;
            len1--;
            len2--;
        }
        
        while( len1 >= 0 )
        {
            int digit = toInc( a.charAt(len1) ) + carry;
            carry = digit / 2;
            digit = digit % 2;
            result = digit + result;
            len1--;
        }
        
        while( len2 >= 0 )
        {
            int digit = toInc( b.charAt(len2) ) + carry;
            carry = digit / 2;
            digit = digit % 2;
            result = digit + result;
            len2--;
        }
        
        if( carry > 0 )
        {
            result = "1" + result;
        }
        
        return result;
    }
    
    private int toInc( Character c )
    {
        return c - '0';
    }
    
    public static void main(String[] args)
    {
    	AddBinary a = new AddBinary();
    	a.addBinary("1", "111");
    }
}
