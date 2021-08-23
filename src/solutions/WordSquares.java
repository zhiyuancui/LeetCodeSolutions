package solutions;

import java.util.ArrayList;
import java.util.List;

public class WordSquares {
    class TrieNode {
        List<String> startWith;
        TrieNode[] children;

        TrieNode() {
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }


    TrieNode root = new TrieNode();

    private void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if(cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }

            cur.children[idx].startWith.add(word);
            cur = cur.children[idx];
        }
    }

    private List<String> findByPrefix(String prefix) {
        List<String> result = new ArrayList<>();

        TrieNode cur = root;

        for(char c : prefix.toCharArray()) {
            int idx = c - 'a';

            if(cur.children[idx] == null) {
                return result;
            }

            cur = cur.children[idx];
        }
        result.addAll(cur.startWith);

        return result;
    }

    public List<List<String>> wordSquares(String[] words) {
        if(words == null || words.length == 0) {
            return new ArrayList<>();
        }

        for(String word: words) {
            addWord(word);
        }

        int len = words[0].length();
        List<String> solution = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        for(String word : words) {
            solution.add(word);
            backtrack(len, result, solution);
            solution.remove(solution.size() - 1);
        }

        return result;
    }

    private void backtrack(int len, List<List<String>> result, List<String> solution) {
        if(solution.size() == len) {
            result.add(new ArrayList<>(solution));
            return;
        }

        int idx = solution.size();

        StringBuilder prefix = new StringBuilder();
        for(String s: solution) {
            prefix.append(s.charAt(idx));
        }

        List<String> startWith = findByPrefix(prefix.toString());

        for(String next : startWith) {
            solution.add(next);
            backtrack(len, result, solution);
            solution.remove(solution.size() - 1);
        }

    }
}
