package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 936 Stamping The Sequence
 */
public class StampSequence {

    public int[] movesToStamp(String stamp, String target) {
        char[] t = target.toCharArray();
        char[] s = stamp.toCharArray();

        int start = 0;

        List<Integer> list = new ArrayList<>();

        boolean[] visited = new boolean[target.length()];

        while(start != target.length()) {
            boolean doneReplace = false;

            for(int i =0; i <= t.length - s.length; i++) {
                if(!visited[i] && canReplace(t,i,s)) {
                    start = doreplace(t, i, stamp.length(), start);
                    list.add(i);
                    visited[i] = true;
                    doneReplace = true;
                    if(start == t.length) {
                        break;
                    }
                }
            }

            if(!doneReplace) {
                return new int[0];
            }
        }

        Collections.reverse(list);
        int[] result = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private boolean canReplace(char[] t, int pos, char[] s) {
        for(int j = 0; j < s.length; j++) {
            if(t[j+pos] != '*' && s[j] != t[pos+j]) {
                return false;
            }
        }
        return true;
    }

    private int doreplace(char[] t, int pos, int len, int start) {
        for(int i = 0; i < len; i++) {
            if(t[i+pos] != '*') {
                t[i+pos] = '*';
                start++;
            }
        }
        return start;
    }

}
