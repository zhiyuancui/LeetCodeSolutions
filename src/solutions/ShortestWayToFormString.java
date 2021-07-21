package solutions;

import java.util.Arrays;

/**
 * 1055 Shortest Way to Form String
 */
public class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        if(source == null || target == null) {
            return 0;
        }

        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        int len1 = s.length;
        int len2 = t.length;

        int[][] dict = new int[len1][26];

        Arrays.fill(dict[len1-1], -1);

        dict[len1-1][s[len1-1]-'a'] = len1 - 1;

        for(int i = len1 - 2;  i >= 0; i--) {
            dict[i] = Arrays.copyOf(dict[i+1], 26);
            dict[i][s[i]-'a'] = i;
        }

        int ans = 0;
        int idx = 0;

        for(char c : t) {
            //检测的是这个字符是否存在
            if(dict[0][c-'a'] == -1) {
                return -1;
            }

            if(dict[idx][c-'a'] == -1) {
                ans++;
                idx = 0;
            }

            idx = dict[idx][c-'a'] + 1;

            if(idx == len1) {
                ans++;
                idx = 0;
            }
        }

        return ans + (idx ==0 ? 0 : 1);
    }
}
