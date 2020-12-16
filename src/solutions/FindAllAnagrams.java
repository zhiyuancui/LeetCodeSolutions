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
        if(s == null || p == null) {
            return new ArrayList<>();
        }


        int[] map = new int[256];

        for(char c : p.toCharArray()) {
            map[c]++;
        }

        int count = 0;

        int left = 0;
        List<Integer> result = new ArrayList<>();

        for(int right=0; right<s.length(); right++) {
            if(map[s.charAt(right)]>0) {
                count++;
            }

            map[s.charAt(right)]--;

            while(right - left +1 == p.length()){
                if(count == p.length()) {
                    result.add(left);
                }

                map[s.charAt(left)]++;
                if(map[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }
        }


        return result;
    }
	
}
