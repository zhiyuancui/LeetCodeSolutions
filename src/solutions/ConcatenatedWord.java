package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWord {
	class TrieNode {
        TrieNode[] children;
        String word;
        boolean isEnd;
        boolean combo; //if this word is a combination of simple words
        boolean added; //if this word is already added in result
        public TrieNode() {
            this.children = new TrieNode[26];
            this.word = new String();
            this.isEnd = false;
            this.combo = false;
            this.added = false;
        }
    }
    private void addWord(String str) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
        node.word = str;
    }
    private TrieNode root;
    private List<String> result;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new TrieNode();
        for (String str : words) {
            if (str.length() == 0) {
                continue;
            }
            addWord(str);
        }
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    private void dfs(TrieNode node, int multi) {
    	//multi counts how many single words combined in this word
        if(node.isEnd && !node.added && multi > 1) {
            node.combo = true;
            node.added = true;
            result.add(node.word);
        }
        searchWord(node, root, multi);
    }
    private void searchWord(TrieNode node1, TrieNode node2, int multi) {
        if (node2.combo) {
            return;
        }
        if (node2.isEnd) {
            //take the pointer of node2 back to root
            dfs(node1, multi + 1);
        }
        for (int  i = 0; i < 26; i++) {
            if (node1.children[i] != null && node2.children[i] != null) {
                searchWord(node1.children[i], node2.children[i], multi);
            }
        }
    }
    
    /**
     * Second Soluiton
     * @param words
     * @return
     */
    public List<String> findAllConcatenatedWordsInADict2(String[] words) {
        if( words.length <= 2 ){            
            return new ArrayList<String>();
        }
        
        List<String> result = new ArrayList<String>();
        
        Set<String> dict = new HashSet<String>();
        for(String word : words) {
            dict.add(word);
        }
        
        for(String word : words) {
            dict.remove(word);
            int len = word.length();
            if( len == 0 ) continue;
            boolean[] canseg = new boolean[len+1];
            canseg[0] = true;
            for(int i = 1; i <= len; i++) {
                for(int j = 1; j <=i; j++) {
                    if( !canseg[i-j] ){
                        continue;
                    }
                    String seg = word.substring(i-j,i);
                    if( dict.contains(seg) )  {
                        canseg[i] = true;
                        break;
                    }
                    
                }
            }
            if( canseg[ canseg.length - 1 ] ) {
                result.add( word );
            }
            dict.add(word);
        }
        
        return result;
    }
    
}
