package solutions;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

	/**
	 * Reference to: https://discuss.leetcode.com/topic/64434/shortest-concise-java-o-n-sliding-window-solution
	 * Time Complexity : O(N)
	 * Space Complexity : O(256)
	 * @param s
	 * @param p
	 * @return
	 */
	public List<Integer> findAnagrams(String s, String p) {
		if( s == null || p == null || s.length() < p.length() ) {
            return new ArrayList<>();
        }
        
        int[] hash = new int[26];
        for( char c : p.toCharArray() ) {
            hash[ c - 'a' ]++;
        }
        
        int left =0;
        int right = 0;
        int count = 0;
        List<Integer> result = new ArrayList<>();
        int len = p.length();
        
        while( right < s.length() ) {
            if( hash[s.charAt(right) - 'a' ] > 0 ) {
                count++;
            }
            hash[ s.charAt(right) - 'a' ]--;
            right++;
            if( count == len ) {
                result.add(left);
            }
            if( right - left == len ) {
                hash[ s.charAt(left) - 'a' ]++;
                if( hash[ s.charAt(left) - 'a' ] > 0 ) {
                    count--;
                }
                left++;
            }
        }
        
        return result;
    }
	
}
