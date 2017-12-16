package solutions;

import java.util.HashMap;

/**
 * 
 * Longest Substring with At Most K Distinct Characters
 * 
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = "eceba",
 * T is "ece" which its length is 3.
 * 
 * 
 * 
 * @author Zhiyuan
 *
 */

public class LongestSubstringWithTwoCharacter {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if( s.length() < 1 ){
        	return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        int left = 0;
        int right = 0;
        int k = 2;
        int max = 0;
        
        for(; right < s.length(); right++) {
            if( map.size() <= k ) {
                map.put( s.charAt(right), right );
            }
            if( map.size() > k ) {
                int leftMost = s.length();
                for( char key : map.keySet() ) {
                    leftMost = Math.min( leftMost, map.get(key) );
                }
                left = leftMost + 1;
                map.remove( s.charAt(leftMost) );
            }
            max = Math.max(max, right - left+1);
        }
        
        return max;
    }
	
	
}
