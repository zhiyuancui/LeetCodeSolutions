package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 763 Partition Labels
 */
public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        int[] hash = new int[26];

        for(char c : s.toCharArray()) {
            hash[c-'a']++;
        }

        int left = 0;
        List<Integer> result = new ArrayList<>();

        Set<Character> set = new HashSet<>();
        int count = 0;

        for(int right = 0; right < s.length(); right++) {
            hash[s.charAt(right) - 'a']--;
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                count++;
            }

            if(hash[s.charAt(right) - 'a'] == 0) {
                count--;
                set.remove(s.charAt(right));
            }

            if(count == 0) {
                result.add(right - left+1);
                left = right+1;
            }
        }

        return result;
    }
}
