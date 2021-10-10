package solutions;

/**
 * 680 Valid Palindrome II
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if( s == null || s.length() == 0 ) {
            return false;
        }

        int left = 0;
        int right = s.length() - 1 ;

        while( left < right ) {
            if( s.charAt(left) != s.charAt(right) ) {
                return isPalindrome(s, left +1 , right) || isPalindrome(s, left, right - 1 );
            } else {
                left++;
                right--;
            }
        }

        return true;
    }

    private boolean isPalindrome( String s, int left, int right ) {
        while( left < right ) {
            if( s.charAt(left) != s.charAt(right) ) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }

}
