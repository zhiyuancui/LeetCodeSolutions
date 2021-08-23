package solutions;

import java.util.HashMap;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 */

public class LongestSubstringWithTwoCharacter {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.equals("") || s.length() == 0 ) {
            return 0;
        }

        int[] map = new int[256];
        int counter = 0;
        int left = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] == 1) counter++;

            if (counter <= 2)
                result = Math.max(result, i - left + 1);

            while (counter > 2) {
                map[s.charAt(left)]--;
                if(map[s.charAt(left)] == 0) counter--;
                left++;
            }
        }
        return result;
    }
}
