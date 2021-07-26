package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 127 Word Ladder
 * Reference to https://leetcode.com/discuss/44110/super-fast-java-solution-two-end-bfs
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> words) {
        if(beginWord == null || endWord == null || words == null) {
            return 0;
        }
        Set<String> wordList = new HashSet<>(words);
        if(!words.contains(endWord)) {
            return 0;
        }

        wordList.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int len = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String cur = queue.poll();
                if(cur.equals(endWord)) {
                    return len;
                }
                List<String> next = getNext(cur, wordList);

                for(String s : next) {
                    queue.offer(s);
                }
            }
            len++;
        }

        return 0;
    }


    private List<String> getNext(String word, Set<String> wordList) {
        wordList.remove(word);
        List<String> result = new ArrayList<>();

        char[] array = word.toCharArray();

        for(int i = 0 ; i < array.length; i++) {
            char c = array[i];
            for(char j = 'a'; j <='z'; j++) {
                if(j == c) {
                    continue;
                }

                array[i] = j;
                String next = new String(array);
                if(wordList.contains(next)) {
                    result.add(next);
                    wordList.remove(next);
                }
            }
            array[i] = c;
        }

        return result;
    }
}
