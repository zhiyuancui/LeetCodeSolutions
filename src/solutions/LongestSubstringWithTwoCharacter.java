package solutions;

import java.util.HashMap;

/**
 * 
 * Longest Substring with At Most K Distinct Characters
 * 
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = ¡°eceba¡±,
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
        
        HashMap<Character, Integer> index = new HashMap<Character, Integer>();
        
        int left = 0;
        int right = 0;
        
        int max = 0;
        
        while( right < s.length() ){
        	if( index.size() <= 2 ){
        		char c = s.charAt( right );
        		index.put(c, right );
        		right++;
        	}
        	if( index.size() > 2 ){
        		int leftMost = s.length();
        		for(int i : index.values() ){
        			leftMost = Math.min(leftMost, i);
        		}
        		
        		char c = s.charAt(leftMost);
        		index.remove( c );
        		left = leftMost + 1;
        	}
        	max = Math.max(max, right - left);
        }
        
        return max;
    }
	
	public static void main(String[] args){
		LongestSubstringWithTwoCharacter l = new LongestSubstringWithTwoCharacter();
		l.lengthOfLongestSubstringTwoDistinct("eceba");
	}
}
