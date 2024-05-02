package solutions;

import java.util.Stack;

/**
 * 1209 Remove All Adjacent Duplicates in String II
 */
public class RemoveAllAdjacantDuplicatesII {
    public String removeDuplicates(String s, int k) {
        int idx = 0;
       int len = s.length();
       int[] count = new int[len];

       char[] stack = s.toCharArray();
       for(int j = 0; j < len;j++,idx++) {
            stack[idx] = stack[j];
            count[idx] = idx > 0 && stack[idx-1] == stack[j] ? count[idx-1] + 1 : 1;
            if(count[idx] == k) {
                idx -= k;
            }
       }

       return new String(stack, 0, idx);
    }
}
