package solutions;

import java.util.HashMap;

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
}
