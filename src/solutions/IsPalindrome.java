package solutions;


public class IsPalindrome {
	
	public boolean isPalindrome2(int x) {
        if( x < 0 ){
            return false;
        }
        
        if( x < 10  )
        {
            return true;
        }
        
        
        int num = x;
        int time = 1;
        while( x >= 10 ){
            x = x/ 10;
            time *= 10;
        }
        
        x = num;
        
        while( x > 0 ){
            int right = x % 10;
            x = x/ 10;
            
            int left = num / time;
            num = num % time;
            time = time / 10;
            
            if( left != right ){
                return false;
            }
        }
        
        return true;
    }

    /**
	 * Valid Palindrome
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
        if( s== null || s.length() == 0 ){
            return true;
        }
        
        s = s.toLowerCase();
        
        int len = s.length();
        int front = 0;
        int end = len - 1;
        
        while( front < end ){
            while( front < s.length() && !isLetter( s.charAt(front) ) ){
                front++;
            }
            
            if( front == s.length() ){
                return true;
            }
            
            while( end >= 0 && !isLetter( s.charAt(end) ) ){
                end--;
            }
            
            if(  s.charAt( front) != s.charAt(end) ){
               break;
            }else {
                front++;
                end--;
            }
        }
        
        return end <= front;
    }
    
    
    private boolean isLetter(Character c){
        return Character.isLetter(c) || Character.isDigit(c);
    }

    /**
     * Valid Palindrome III
     * @param s
     * @param k
     * @return
     */
    public boolean isValidPalindrome(String s, int k) {

        if(s == null || s.length() == 0) {
            return true;
        }

        int len = s.length();

        int[][] dp = new int[len+1][len+1];

        for(int i = len; i > 0; i--) {
            for(int j = i; j <= len; j++) {
                if(s.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = j - i < 2 ? 0 : dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                }
            }
        }

        return dp[1][len] <= k;
    }

}
