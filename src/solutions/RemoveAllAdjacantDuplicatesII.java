package solutions;

import java.util.Stack;

/**
 * 1209 Remove All Adjacent Duplicates in String II
 */
public class RemoveAllAdjacantDuplicatesII {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        Stack<Integer> counts = new Stack<>();
        for(int i = 0; i < sb.length(); i++) {
            if(i == 0 || sb.charAt(i) != sb.charAt(i-1)) {
                counts.push(1);
            } else {
                int incre = counts.pop() + 1;
                if(incre == k) {
                    sb.delete(i-k+1,i+1);
                    i = i-k;
                } else {
                    counts.push(incre);
                }
            }
        }

        return sb.toString();
    }
}
