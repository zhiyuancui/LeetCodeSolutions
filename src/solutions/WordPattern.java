package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 290 Word Pattern
 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
        String[] parts = str.split("\\s+");
        if( parts.length == 0 ){
            return false;
        }
        
        if( parts.length != pattern.length() ){
            return false;
        }
        
        HashMap<Character, String> map = new HashMap<Character,String>();
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < pattern.length(); i++){
            Character letter = pattern.charAt(i);
            if( map.containsKey( letter ) ){
                if( !parts[ i ].equals( map.get( letter) ) ){
                    return false;
                }
            }else{
                if( !set.contains( parts[i] ) ){
                    map.put(letter, parts[i]);
                    set.add( parts[i] );
                }else{
                    return false;
                }
            }
        }
        
        return true;
    }
	
	/**
	 * 
	 * Given a pattern and a string str, find if str follows the same pattern.
	 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
	 * Examples:
	 * pattern = "abab", str = "redblueredblue" should return true.
	 * pattern = "aaaa", str = "asdasdasdasd" should return true.
	 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
	 * 
	 * Reference to :https://leetcode.com/discuss/63252/share-my-java-backtracking-solution
	 * 
	 * @param pattern
	 * @param str
	 * @return
	 */
	public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        
        Set<String> set = new HashSet<>();
        
        return isMatch(str, 0, pattern, 0, map, set);
    }
	
	private boolean isMatch(String str, int strIndex, String pattern, int patternIndex, Map<Character, String> map, Set<String> set){
		
		if( strIndex == str.length() && patternIndex == pattern.length() ){
			return true;
		}
		
		if( strIndex == str.length() || patternIndex == pattern.length() ){
			return false;
		}
		
		char c = pattern.charAt(patternIndex);
		
		if( map.containsKey( c) ){
			String s = map.get(c);
			if( !str.startsWith(s,strIndex) ){
				return false;
			}
			
			return isMatch( str, strIndex+s.length(), pattern, patternIndex +1, map, set);
		}
		
		for(int k = strIndex; k < str.length(); k ++){
			String p = str.substring(strIndex,k+1);
			
			if( set.contains(p) ){
				continue;
			}
			
			map.put(c, p);
			set.add(p);
			
			if( isMatch(str, k + 1, pattern, patternIndex + 1, map, set) ){
				return true;
			}
			
			map.remove(c);
			set.remove(p);
		}
		
		return false;
	}
}
