package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Reference to https://discuss.leetcode.com/topic/113547/three-ways-to-solve-this-problem-in-java
 * @author Zhiyuan
 *
 */
public class WordFilter {

    class TrieNode {
        Map<Character, TrieNode> children;
        int index;

        public TrieNode() {
            children = new HashMap<>();
            index = 0;
        }
    }

    TrieNode root = new TrieNode();

    public WordFilter(String[] words) {

        for(int index = 0; index <words.length; index++) {
            String word = words[index] + "#";
            for(int i = 0; i < word.length(); i++) {
                TrieNode cur = root;
                cur.index = index;
                for(int j = i; j < 2*word.length() - 1; j++) {
                    char c = word.charAt(j % word.length());
                    if(!cur.children.containsKey(c)) {
                        cur.children.put(c, new TrieNode());
                    }
                    cur = cur.children.get(c);
                    cur.index = index;
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode cur = root;
        String s = suffix +"#"+ prefix;
        for(char c : s.toCharArray()) {
            if(!cur.children.containsKey(c)) {
                return -1;
            }

            cur = cur.children.get(c);
        }

        return cur.index;
    }
}
