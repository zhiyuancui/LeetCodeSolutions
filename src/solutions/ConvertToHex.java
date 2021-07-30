package solutions;

/**
 * 405 Convert a Number to Hex
 */
public class ConvertToHex {

	public String toHex(int num) {
        
        char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        
        int mask = 15;
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < 8; i++){
            res.append( hex[ num & mask ] );
            num = num >> 4;
        }
        
        String result = res.reverse().toString();
        
        int zero = 0;
        int len = result.length();
        while( zero < len && result.charAt(zero) == '0') {
            zero++;
        }
        
        return zero == len ? "0" : result.substring(zero,len);
        
    }
}
