package solutions;

import java.util.*;

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
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        if( strs == null || strs.length == 0 ){
            return result;
        }
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String s : strs ){
            String code = encode(s);
            if( map.containsKey( code ) ){
                List<String> temp = map.get( code );
                temp.add( s );
            }else{
                List<String> anagram =  new ArrayList<String>();
                map.put(code, anagram);
            }
        }
        
        for(List<String> anagrams : map.values() ){
            Collections.sort( anagrams );
            result.add( anagrams );
        }
        
        return result;
    }
    
    
}
