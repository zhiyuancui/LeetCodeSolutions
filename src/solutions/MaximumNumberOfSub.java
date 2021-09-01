package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1297 Maximum Number of Occurences of a Substring
 */
public class MaximumNumberOfSub {
    // 当某个长度大于minSize的子串满足条件时，其前minSize个字符组成的字串也必定符合条件。故我们只需找出长度为minSize的子串即可
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();

        int left = 0, right = 0, result = 0;
        int[] count = new int[26];

        while(right < s.length()) {
            count[s.charAt(right) -'a']++;
            if(count[s.charAt(right) -'a'] == 1) {
                maxLetters--;
            }
            right++;

            while(maxLetters < 0 || right - left > minSize) {
                count[s.charAt(left) - 'a']--;
                if(count[s.charAt(left) - 'a'] == 0) {
                    maxLetters++;
                }
                left++;
            }

            if(right - left == minSize) {
                String key = s.substring(left, right);
                map.put(key, map.getOrDefault(key, 0) + 1);
                result = Math.max(result, map.get(key));
            }
        }

        return result;
    }
}
