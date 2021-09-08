package solutions;

import java.util.*;

/**
 * 472 Concatenated Word
 */
public class ConcatenatedWord {
    /**
     * Solution I
     * @param words
     * @return
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if(words == null || words.length == 0 ) {
            return new ArrayList<>();
        }

        Set<String> wordSet = new HashSet<>();
        for(String word : words) {
            if(word.length() > 0) {
                wordSet.add(word);
            }
        }

        List<String> result = new ArrayList<>();
        for(String word: words) {
            if(word.length() > 0) {
                wordSet.remove(word);
                if(canbreak(word, wordSet)) {
                    result.add(word);
                }
                wordSet.add(word);
            }
        }

        return result;
    }

    private boolean canbreak(String word, Set<String> dict) {
        boolean[] dp = new boolean[word.length()+1];

        dp[0] = true;

        for(int i = 1; i <= word.length(); i++) {
            for(int j = 1; j <= i; j++) {
                if(!dp[i-j]) {
                    continue;
                }
                String seg = word.substring(i-j,i);
                if(dict.contains(seg)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];
    }

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            isWord = false;
            children = new HashMap<>();
        }
    }

    TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict2(String[] words) {
        addToTrie(words);

        List<String> result = new ArrayList<>();
        for(String word : words) {
            boolean[] visited = new boolean[word.length()];
            if(isConcat(word, 0, 0,visited)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean isConcat(String word, int pos, int count, boolean[] visited) {
        if(pos >= word.length()) {
            return count > 1;
        }

        if(visited[pos]) {
            return false;
        }

        TrieNode cur = root;

        for(int i = pos; i < word.length(); i++) {
            if(cur.children.containsKey(word.charAt(i))) {
                cur = cur.children.get(word.charAt(i));
                if(cur.isWord && isConcat(word, i+1, count+1, visited)) {
                    return true;
                }
            } else {
                break;
            }
        }

        visited[pos] = true;
        return false;
    }

    private void addToTrie(String[] words) {
        for(String word : words) {
            TrieNode cur = root;

            for(char c : word.toCharArray()) {
                if(!cur.children.containsKey(c)) {
                    cur.children.put(c, new TrieNode());
                }
                cur = cur.children.get(c);
            }
            cur.isWord = true;
        }
    }
}
