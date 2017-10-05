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
		if( s == null || p == null || s.length() == 0 || p.length() == 0 ) {
            return new ArrayList<>();
        }
        int[] hash = new int[256];
        for( char c : p.toCharArray() ) {
            hash[c]++;
        }
        
        List<Integer> list = new ArrayList<>();
        int left = 0, right = 0, count = p.length();
        while( right < s.length() ) {
            if( hash[s.charAt(right)] >= 1 ) {
                count--;
            }
            hash[ s.charAt(right) ]--;
            right++;
            
            if( count == 0 ) {
                list.add(left);
            }
            if( right - left == p.length() ){ 
                if( hash[ s.charAt(left) ] >= 0 ) {
                    count++;
                }
                hash[ s.charAt(left) ]++;
                left++;
            }
        }
        
        return list;
    }
	
}
