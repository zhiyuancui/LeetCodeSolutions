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
}
