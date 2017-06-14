package solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
        if( s == null ){
            return 0;
        }
        
        if( s.length() < 2 ){
            return s.length();
        }
        
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        
        for(int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            int count = map.getOrDefault(letter, 0) + 1;
            map.put( letter, count);
        }
        
        int longest = 0;
        boolean hasOdd = false;
        for(char letter: map.keySet() ){
            int count = map.get(letter);
            if( count >= 2 ){
                if( count % 2 != 0 ){
                    count = count - 1;
                    hasOdd = true;
                }
                longest += count;
            } else if( count == 1 ) {
                hasOdd = true;
            }
        }
        
        return hasOdd ? longest+1:longest;
    }
}
