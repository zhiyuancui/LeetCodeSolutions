package solutions;

/**
 * 5 Longest Palindromic Substring
 */
public class LongestPalindromeSubString {
	
	/**
	 * Center
	 * Longest Palindromic Substring
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
        int len = s.length();
        if( len <= 1 ){
        	return s;
        }
        
        int start = 0;
        int maxLen = 0;
        
        for(int i = 1; i < len; i++){
        	int low = i -1; 
        	int high = i;
        	
        	//Find a palindrome string which is centered at i -1. length is even
        	while( low >= 0 && high < len && s.charAt(low) == s.charAt(high) ){
        		low--;
        		high++;
        	}
        	
        	if( high - low - 1 > maxLen ){
        		maxLen = high - low - 1;
        		start = low + 1;
        	}
        	
        	//Find a palindrome string which is centered at i. length is odd
        	low = i -1; high = i +1;
        	while( low >= 0 && high < len && s.charAt(low) == s.charAt(high) ){
        		low--;
        		high++;
        	}
        	if( high - low - 1 > maxLen ){
        		maxLen = high - low - 1;
        		start = low + 1;
        	}
        }
        
        return s.substring(start, start + maxLen);
        
    }
	
	
	/**
	 * Manacher Algorithms
	 * Referece to http://www.cnblogs.com/TenosDoIt/p/3675788.html
	 * @param s
	 * @return
	 */
	public String longestPalindrome2(String s){
		int len = s.length();
		
		if( len <= 1 ){
			return s;
		}
		
		String str = preProcess(s);
		len = str.length();
		int center = 0;
		int max = 0;
		
		int[] p = new int[len];
		
		for(int i = 1; i < len - 1; i++){
			p[i] = max > i ? Math.min(p[2*center - i], max - i) : 1;
			
			while( str.charAt( i + p[i]) == str.charAt(i-p[i]) ){
				p[i]++;
			}
			
			if( i + p[i] > max ){
				max = i + p[i];
				center = i;
			}
		}
		
		int maxLen = 0;
		int index = 0;
		for(int i = 1; i < len - 1; i++){
			if( p[i] > maxLen ){
				maxLen = p[i];
				index = i;
			}
		}
		
		return s.substring((index-maxLen)/2, (index-maxLen)/2 +maxLen - 1);
	}
	
	private String preProcess(String s){
		StringBuilder sb = new StringBuilder();
		sb.append('$');
		sb.append('#');
		
		int len = s.length();
		
		for(int i = 0; i < len; i++){
			sb.append(s.charAt(i) );
			sb.append('#');
		}
		sb.append('^');
		
		return sb.toString();
	}
}
