package solutions.amazon;

import java.util.HashSet;

public class KSubstringNoRepeats {
    public int numKLenSubstrNoRepeats(String S, int K) {
        int total = 0;
        int left = 0;
        int right = 0;
        int[] hash = new int[26];
        HashSet<Character> set = new HashSet<>();
        int repeats = 0;

        while(right < S.length()) {
            char c = S.charAt(right);
            hash[c-'a']++;
            if(hash[c-'a'] == 1) {
                repeats++;
            }
            if(repeats == K) {
                total++;
            }
            if(right-left+1 >= K) {
                hash[S.charAt(left)-'a']--;
                if(hash[S.charAt(left)-'a'] == 0) {
                    repeats--;
                }
                left++;
            }
            right++;
        }

        return total;
    }

}
