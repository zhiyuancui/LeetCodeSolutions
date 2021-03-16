package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamChecker {
    TrieNode root;
    List<Character> history;
    public StreamChecker(String[] words) {
        root = new TrieNode();
        buildTree(words);
        history = new ArrayList<>();
    }

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            isWord = false;
            children = new HashMap<>();
        }
    }

    public boolean query(char letter) {
        history.add(letter);
        TrieNode cur = root;

        for(int i = history.size() - 1; i >= 0; i--) {
            char c = history.get(i);
            if(!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
            if(cur.isWord) {
                return true;
            }
        }

        return false;
    }

    private void buildTree(String[] words) {
        for(String s : words) {
            StringBuilder sb = new StringBuilder(s);
            insert(sb.reverse().toString());
        }
    }

    private void insert(String s) {

        TrieNode cur = root;
        for(char c : s.toCharArray()) {
            if(!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
}
