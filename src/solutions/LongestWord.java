package solutions;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 720 Longest Word in Dictionary
 */
public class LongestWord {
    public String longestWord(String[] words) {
        if(words == null || words.length == 0) {
            return "";
        }

        Set<String> set = new HashSet<>();

        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
            if(a.length() != b.length()) {
                return b.length() - a.length();
            } else {
                return a.compareTo(b);
            }
        });

        for(String word: words) {
            queue.add(word);
            set.add(word);
        }

        while(!queue.isEmpty()) {
            String cur = queue.poll();
            int len = cur.length();

            boolean isBreak = false;
            for(int i = len -1; i > 0; i--) {
                String seg = cur.substring(0,i);
                if(!set.contains(seg)) {
                    isBreak = true;
                    break;
                }
            }

            if(!isBreak) {
                return cur;
            }
        }

        return "";
    }
}
