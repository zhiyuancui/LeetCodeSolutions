package solutions.amazon;

import java.util.Arrays;

public class ReorganizeString {
    public String reorganizeString(String S) {
        if(S == null || S.length() == 0) {
            return "";
        }

        int len = S.length();

        int[] counts = new int[26];

        for(char c : S.toCharArray()) {
            counts[c-'a'] += 100;
        }

        for(int i = 0; i < 26; i++) {
            counts[i] += i;
        }

        Arrays.sort(counts);

        char[] ans = new char[len];

        int t = 1;
        for(int code: counts) {
            int count = code / 100;
            char ch = (char)('a' + (code%100));
            if( count > (len+1)/2) return "";

            for(int i = 0; i < count; i++) {
                if( t >= len) {
                    t = 0;
                }
                ans[t] = ch;
                t += 2;
            }
        }

        return String.valueOf(ans);
    }
}
