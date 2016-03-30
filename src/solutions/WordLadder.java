package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        if( wordList == null || wordList.size() == 0 ){
            return 0;
        }
        
        wordList.add( beginWord );
        wordList.add( endWord );
        
        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer( beginWord );
        hash.add( beginWord );
        
        int len = 1;
        while( !queue.isEmpty() ){
            len++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                for(String nextWord : getNextWords( word, wordList ) ){
                    if( hash.contains( nextWord ) ){
                        continue;
                    }
                    if( nextWord.equals(endWord) ){
                        return len;
                    }
                    
                    hash.add( nextWord );
                    queue.offer( nextWord );
                }
            }
        }
        
        return 0;
    }
    
    private String replace(String s, int index, char c){
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String( chars );
    }
    
    private List<String> getNextWords(String word, Set<String> dict ){
        List<String> nextWords = new ArrayList<String>();
        for( char c = 'a'; c <= 'z'; c++ ){
            for(int i = 0; i < word.length(); i++){
                if( c == word.charAt(i) ){
                    continue;
                }
                
                String nextWord = replace(word, i, c);
                if( dict.contains( nextWord ) ){
                    nextWords.add( nextWord );
                }
            }
        }
        
        return nextWords;
    }
}
