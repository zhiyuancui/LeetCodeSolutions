package solutions;

public class Anagram {

		
	/**
	 * Given two strings s and t, 
	 * write a function to determine if t is an anagram of s.
	 * For example, s = "anagram", t = "nagaram", return true.
	 * s = "rat", t = "car", return false.
	 */
public boolean isAnagram(String s, String t) {
        
        if( s == null && t == null )
        {
            return true;
        }
        if( s== null || t == null)
        {
            return false;
        }
        if( s.length() != t.length() )
        {
            return false;
        }
        
        
        return encode(s).equals( encode(t) );
    }
    
    private String encode(String s)
    {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        
        return new String( temp );
    }
}
