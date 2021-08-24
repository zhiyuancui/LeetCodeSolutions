package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 205 Isomorphic Strings
 */
public class IsomorphicString {
	public boolean isIsomorphic(String s, String t) {
        if( ( s== null && t == null ) || ( s.length() == 0 && t.length() == 0 ) ){
            return true;
        }
        if( s== null || t == null || s.length() == 0 || t.length() == 0 || s.length() != t.length()){
            return false;
        }
        
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++){
            Character letter = s.charAt(i);
            if( map.containsKey( letter ) ){
                if( t.charAt(i) != map.get(letter) ){
                    return false;
                }
            }else if( map.containsValue( t.charAt(i))){
                return false;
            }else{
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        
        return true;
    }
	
	public boolean isIsomorphic2(String s, String t) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
    
        for(Integer i = 0; i < s.length(); i++) {
        	Integer r1 = m1.put(s.charAt(i), i);
            Integer r2 = m2.put(t.charAt(i), i);
            if( r1 != r2 ) {
                return false;
            }
        }
        return true;
    }
}
