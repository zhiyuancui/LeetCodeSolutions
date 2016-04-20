package solutions;

public class LongestPalindromeSubString {
	
	/**
	 * Center
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
	 * Manacher
	 * @param s
	 * @return
	 */
	private String longestPalindrome2(String s){
		return "";
	}
	
	public static void main(String[] args){
		LongestPalindromeSubString l = new LongestPalindromeSubString();
		String result = l.longestPalindrome("civilwartesting"
				+ "whetherthatnaptionoranynarti"
				+ "onsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecome"
				+ "todedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnat"
				+ "ionmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicate"
				+ "wecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehavecon"
				+ "secrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwh"
				+ "atwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretoth"
				+ "eulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobehereded"
				+ "icatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontoth"
				+ "atcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadsh"
				+ "allnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofth"
				+ "epeoplebythepeopleforthepeopleshallnotperishfromtheearth");
	}
}
