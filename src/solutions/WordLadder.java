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

public class WordLadder {
public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if( wordList == null || wordList.size() == 0 ){
            return 0;
        }
        
        wordList.add( beginWord );
        wordList.add( endWord );
        
        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer( beginWord );
        visited.add( beginWord );
        
        int len = 1;
        while( !queue.isEmpty() ){
            len++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                for(String nextWord : getNextWords( word, wordList ) ){
                    if( visited.contains( nextWord ) ){
                        continue;
                    }
                    if( nextWord.equals(endWord) ){
                        return len;
                    }
                    
                    visited.add( nextWord );
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
    
    private List<String> getNextWords(String word, List<String> dict ){
        List<String> nextWords = new ArrayList<String>();
        for( char c = 'a'; c <= 'z'; c++ ){
            for(int i = 0; i < word.length(); i++){
                if( c == word.charAt(i) ){
                    continue;
                }
                
                String nextWord = replace(word, i, c);
                if( dict.contains( nextWord ) ){
                	System.out.print( nextWord +"\t");
                    nextWords.add( nextWord );
                }
            }
        }
        System.out.println("");
        return nextWords;
    }
    

    
    
    /**
     * Two-end BFS
     * Reference to https://leetcode.com/discuss/44110/super-fast-java-solution-two-end-bfs
     * @param args
     */
    public List<List<String>> findLadders3(String start, String end, Set<String> dict) {
        // hash set for both ends
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();

        // initial words in both ends
        set1.add(start);
        set2.add(end);

        // we use a map to help construct the final result
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        // build the map
        bfs(dict, set1, set2, map, false);

        List<List<String>> res = new ArrayList<List<String>>();
        List<String> sol = new ArrayList<String>(Arrays.asList(start));

        // recursively build the final result
        generateList(start, end, map, sol, res);

        return res;
      }

      private boolean bfs(Set<String> dict, Set<String> start, Set<String> end, Map<String, List<String>> map, boolean BottomToTop) {
        if (start.isEmpty()) {
          return false;
        }

        if (start.size() > end.size()) {
          return bfs(dict, end, start, map, !BottomToTop);
        }

        // remove words on current both ends from the dict
        dict.removeAll(start);
        dict.removeAll(end);

        // as we only need the shortest paths
        // we use a boolean value help early termination
        boolean done = false;

        // set for the next level
        Set<String> set = new HashSet<String>();

        // for each string in end 1
        for (String str : start) {
        	  List<String> nextWord = getNextWord(dict, str);

        	  for( String word : nextWord){

              // make sure we construct the tree in the correct direction
              String key = BottomToTop ? word : str;
              String val = BottomToTop ? str : word;

              List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();

              if (end.contains(word)) {
                done = true;

                list.add(val);
                map.put(key, list); 
              } 

              if (!done && dict.contains(word)) {
                set.add(word);

                list.add(val);
                map.put(key, list);
              }
            }
        }

        // early terminate if done is true
        return done || bfs(dict, end, set, map, !BottomToTop);
      }

      private void generateList(String start, String end, Map<String, List<String>> map, List<String> sol, List<List<String>> res) {
        if (start.equals(end)) {
          res.add(new ArrayList<String>(sol));
          return;
        }

        // need this check in case the diff between start and end happens to be one
        // e.g "a", "c", {"a", "b", "c"}
        if (!map.containsKey(start)) {
          return;
        }

        for (String word : map.get(start)) {
          sol.add(word);
          generateList(word, end, map, sol, res);
          sol.remove(sol.size() - 1);
        }
      }
      
      private List<String> getNextWord(Set<String> dict, String str){
    	  ArrayList<String> result = new ArrayList<String>();
    	  
    	  for(int i = 0; i < str.length(); i++){
    		  for( char ch = 'a'; ch <= 'z'; ch++){
	    		  if( str.charAt(i) == ch ){
	    			  continue;
	    		  }
	    		  String next = replace(str, i, ch);	    
	    		  result.add(next);
    		  }
    	  }
    	  return result;
      }
      
    public static void main(String[] args){
    	WordLadder w = new WordLadder();
    	Set<String> wordList = new HashSet<String>();
    	wordList.add("hot");
    	wordList.add("dot");
    	wordList.add("dog");
    	wordList.add("lot");
    	wordList.add("log");

    	List<List<String>> result = w.findLadders3("hit", "cog", wordList);
    	
    	for(List<String> path : result){
    		for(String s : path){
    			System.out.print(s + " ");
    		}
    		System.out.println();
    	}
    	
    }
}
