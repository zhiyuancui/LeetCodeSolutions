package solutions;

public class ReverseString {

	/**
	 * Reverse String II
	 * @param s
	 * @param k
	 * @return
	 */
	public String reverseStr(String s, int k) {
        
        if( k < 2 || s == null || s.length() == 0 ){
            return s;
        }
        
        int len = s.length();
        String result = "";
        
        
        for(int i = 0 ; i < len; i+=2*k){
            int end = i + 2*k < len ? i + 2*k : len;
            String seg = s.substring(i,end);
            String reverse = reverse( seg, k);
            result += reverse;
        }
        
        return result;
    }
    
    private String reverse(String seg, int k){
        if( seg.length() < k ){
            return new StringBuilder(seg).reverse().toString();
        }
        
        String left = seg.substring(k);
        String re = seg.substring(0,k);
        return new StringBuilder(re).reverse() + left;
    }
}
