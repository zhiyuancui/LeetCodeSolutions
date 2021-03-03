package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumNumberOfSub {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s == null) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = minSize; j <= maxSize; j++) {
                if (i + j > s.length()) {
                    break;
                }
                String seg = s.substring(i, i + j);
                if (isValid(seg, maxLetters)) {
                    int count = map.getOrDefault(seg, 0) + 1;
                    map.put(seg, count);
                }
            }
        }

        int max = 0;
        for (String key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }

        return max;
    }

    private boolean isValid(String s, int maxLetters) {
        Set<Character> set = new HashSet();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        return set.size() <= maxLetters;
    }
}
