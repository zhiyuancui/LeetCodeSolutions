package solutions;

public class ShortestPalindrome {
	
	public String shortestPalindrome(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().substring(0, s.length() - getCommonLength(s)) + s;
    }

    private int getCommonLength(String str) {
        StringBuilder builder = new StringBuilder(str);
        String rev = new StringBuilder(str).reverse().toString();
        builder.append("#").append(rev);
        int[] p = new int[builder.length()];
        for (int i = 1; i < p.length; i++) {
            int j = p[i - 1];
            while (j > 0 && builder.charAt(i) != builder.charAt(j)) {
            	j = p[j - 1];
            }
            p[i] = j == 0 ? (builder.charAt(i) == builder.charAt(0) ? 1 : 0) : j + 1;
        }
        return p[p.length - 1];
    }
    
    
    /**
     * O(n^2) method
     * @param s
     * @return
     */
    public String shortestPalindrome2(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        int len = s.length(), tail = len;
        StringBuilder builder = new StringBuilder();
        while (1 < tail) {
            if (isPalindrome(s.substring(0, tail))) {
                builder = builder.append(s.substring(tail, len)).reverse();
                break;
            }
            tail--;
        }
        if (builder.length() == 0) {
            builder = builder.append(s.substring(tail, len)).reverse();
        }
        return builder.append(s).toString();
    }

    private boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return false;
        }
        return true;
    }
    
    public static void main(String[] args){
    	ShortestPalindrome s = new ShortestPalindrome();
    	System.out.println(  s.shortestPalindrome( "abcd" ) );
    }
}
