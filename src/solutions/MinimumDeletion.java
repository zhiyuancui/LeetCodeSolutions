package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * 1647 Minimum Deletions to Make Character Frequencies Unique
 */
public class MinimumDeletion {
    public int minDeletions(String s) {
        int[] hash = new int[26];

        for(char c : s.toCharArray()) {
            hash[c-'a']++;
        }

        int result =0;
        Set<Integer> set = new HashSet<>();

        for(int c : hash) {
            if(c != 0) {
                while(set.contains(c)) {
                    c--;
                    result++;
                }
                if(c != 0) {
                    set.add(c);
                }
            }
        }

        return result;
    }
}
