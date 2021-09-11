package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 291 Word Pattern II
 */
public class WordPatternII {
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
