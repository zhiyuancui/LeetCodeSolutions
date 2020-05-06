package solutions.amazon;

import java.util.HashMap;
import java.util.Map;

class StreamChecker {

    TrieNode root = new TrieNode();
    String s;

    public StreamChecker(String[] words) {
        for(String s : words) {
            insert(s);
        }
    }

    public boolean query(char letter) {
        s += letter;
        return search(s);
    }

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;
        TrieNode() {
            isWord = false;
            children = new HashMap<>();
        }
    }

    public void insert(String s) {
        TrieNode cur = root;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String s) {
        TrieNode cur = root;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(!cur.children.containsKey(c)) {
                break;
            } else {
                cur = cur.children.get(c);
            }

            if(cur.isWord) {
                break;
            }
        }

        return cur.isWord;
    }
}
