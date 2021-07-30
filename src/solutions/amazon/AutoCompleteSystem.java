package solutions.amazon;

import java.util.*;

/**
 * 642 Design Search Autocomplete System
 */
public class AutoCompleteSystem {
    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> count;
        String word;

        public TrieNode() {
            children = new HashMap<>();
            word = null;
            count = new HashMap<>();
        }
    }

    TrieNode root = new TrieNode();

    private void addWord(String word, int times) {
        TrieNode cur = root;

        for(char c : word.toCharArray()) {
            if(!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
            cur.count.put(word, cur.count.getOrDefault(word,0)+times);
        }
        cur.word = word;
    }

    public AutoCompleteSystem(String[] sentences, int[] times) {

        for(int i = 0; i < sentences.length; i++) {
            addWord(sentences[i], times[i]);
        }
    }


    String prefix = "";

    public List<String> input(char c) {
        if(c == '#') {
            addWord(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }

        prefix += c;
        List<String> result = new ArrayList<>();
        TrieNode cur = root;

        for(char cc : prefix.toCharArray()) {
            if(!cur.children.containsKey(cc)) {
                return new ArrayList<>();
            }
            cur = cur.children.get(cc);
        }

        Map<String, Integer> copy = cur.count;
        PriorityQueue<String> queue = new PriorityQueue<>((a,b) -> {
            if(copy.get(a) != copy.get(b)) {
                return copy.get(a) - copy.get(b);
            } else {
                return b.compareTo(a);
            }
        });

        for(String key: cur.count.keySet()) {
            queue.add(key);
            if(queue.size() > 3) {
                queue.poll();
            }
        }

        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }

        Collections.reverse(result);
        return result;
    }
}
