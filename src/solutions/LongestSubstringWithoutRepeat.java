package solutions;

import java.util.HashSet;

/**
 * Longest Substring Without Repeating Characters
 * @author Zhiyuan
 *
 */
public class LongestSubstringWithoutRepeat {
	public int lengthOfLongestSubstring(String s) {
        if( s== null || s.length() == 0 ){
            return 0;
        }
        
        HashSet<Character> set = new HashSet<Character>();
        
        int leftBound = 0, max = 0;
        
        for(int right = 0; right < s.length(); right++){
            if( set.contains( s.charAt(right) ) ){
                while( leftBound < right && s.charAt( leftBound ) != s.charAt(right) ){
                    set.remove( s.charAt( leftBound ) );
                    leftBound++;
                }
                leftBound++;
            }else{
                set.add( s.charAt(right) );
                max = Math.max(max, right - leftBound + 1 );
            }
        }
        
        return max;
    }
}
