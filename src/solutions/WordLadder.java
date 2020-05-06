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
    
    private String replace(String s, int index, char c){
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String( chars );
    }

    /**
     * Two-end BFS
     * Reference to https://leetcode.com/discuss/44110/super-fast-java-solution-two-end-bfs
     * @param
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
      
      /**
       * @param beginWord
       * @param endWord
       * @param wordList
       * @return
       */
      public int ladderLength(String beginWord, String endWord, List<String> wordList) {
          Queue<String> queue = new LinkedList<String>();
          queue.add(beginWord);
          int len=1;
          HashSet<String> set = new HashSet<String>(wordList);

          while(!queue.isEmpty()){
              int queueSize = queue.size();
              for(int i=0; i<queueSize; i++){
                  String word = queue.poll();
                  if(word.equals(endWord)) return len;
                  else addToQueue(set, queue, word);
              }
              len++;
          }
          return 0;
      }
      private void addToQueue(HashSet<String> wordList, Queue<String> queue, String word){
          wordList.remove(word);
      
          for(int i = 0; i < word.length(); i++) {
        	  for(char j ='a'; j <= 'z'; j++) {
        		  if( j == word.charAt(i) )continue;
        		  String next = replace(word, i, j);
                  if(wordList.contains(next)){
                      queue.offer(next);
                      wordList.remove(next);
                  }
        	  }
          }
      }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        HashSet<String> set = new HashSet<String>(wordList);
        Map<String, List<String>> parents = new HashMap<>();
        parents.put(beginWord, null);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i=0; i<queueSize; i++){
                String word = queue.poll();
                if(word.equals(endWord)){
                    backtrack(result, new ArrayList<>(), parents, endWord);
                    return result;
                } else {
                    addToQueue(set, queue, word, parents, endWord);
                }
            }
        }

        return result;
    }

    private void addToQueue(HashSet<String> wordList, Queue<String> queue, String word, Map<String, List<String>> parents, String endWord){
        wordList.remove(word);

        for(int i = 0; i < word.length(); i++) {
            for(char j ='a'; j <= 'z'; j++) {
                if( j == word.charAt(i) )continue;
                String next = replace(word, i, j);
                if(wordList.contains(next) || next.equals(endWord)){
                    if(!parents.containsKey(next)) {
                        parents.put(next, new ArrayList<>());
                    }
                    parents.get(next).add(word);
                    queue.offer(next);
                    wordList.remove(next);
                }
            }
        }
    }

    private void backtrack(List<List<String>> result, List<String> solution, Map<String, List<String>> parents, String word) {
        if(parents.get(word) ==null ) {
            solution.add(0, word);
            result.add(new ArrayList<>(solution));
            return;
        }

        solution.add(0, word);
        for(String prev: parents.get(word)) {
            backtrack(result, solution, parents, prev);
            solution.remove(0 );
        }
    }

      public static void main(String[] args) {
            WordLadder wordLadder = new WordLadder();
            List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
            List<List<String>> result = wordLadder.findLadders("hit", "cog", wordList);
            for(List<String> list : result) {
                for(String str : list) {
                    System.out.print(str+ " ");
                }
                System.out.println();
            }
      }
}
