package solutions;

import java.util.Arrays;

/**
 * 833. Find And Replace in String
 */
public class FindReplaceString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int len = s.length();

        int[] match = new int[len];

        Arrays.fill(match, -1);

        for(int i = 0; i < indices.length; i++) {
            if(s.startsWith(sources[i], indices[i])) {
                match[indices[i]] =  i;
            }
        }

        StringBuilder sb = new StringBuilder();

        int idx = 0;

        while(idx < len) {
            if(match[idx] != -1) {
                sb.append(targets[match[idx]]);
                idx += sources[match[idx]].length();
            } else {
                sb.append(s.charAt(idx));
                idx++;
            }
        }

        return sb.toString();
    }
}
