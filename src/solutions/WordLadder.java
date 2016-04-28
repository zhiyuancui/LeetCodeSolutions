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
    
    /**
     * Word Ladder II
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        
        wordList.add( beginWord );
        wordList.add( endWord );
        
        LadderNode root = bfs(beginWord, endWord, wordList);
        treeTrave( root );
        List<String> path = new ArrayList<String>();
        
        dfs(root, ladders, path, endWord );
        
        //filter result find shortest;
//        int min = Integer.MAX_VALUE;
//        for(List<String> solution : ladders ){
//        	min = Math.min(min, solution.size() );
//        }
        return ladders;
    }
    
    private void dfs(LadderNode root, List<List<String>> ladders,List<String> path, String end )
    {
        if( root.next == null ){
            if( root.val.equals( end ) ){
                path.add( root.val );
                ladders.add(new ArrayList<String>( path ));
            }else{
            	path.add("fake");
            }
            return;
        }
        
        path.add( root.val );
        Iterator it = root.next.entrySet().iterator();
        while( it.hasNext() ){
        	Map.Entry<String, LadderNode> pair = ( Map.Entry<String, LadderNode> )it.next();
        	dfs( pair.getValue(), ladders, path, end);
        	path.remove( path.size() - 1 );
        }
        
    }
    
    private LadderNode bfs( String start, String end, Set<String> dict )
    {
        Queue<LadderNode> q = new LinkedList<LadderNode>();
        Set<String> set = new HashSet<String>();
        
        LadderNode root = new LadderNode( start );
        q.offer( root );
        
        boolean touchEnd = false;
  
        while( !q.isEmpty() ){ 
        	int size = q.size();
        	for(int i = 0; i < size; i++ ){ 
	        	LadderNode cur = q.poll();
	        	set.add( cur.val );
	        
	            List<String> nextList = expand( cur.val, dict );
	            for(String nextWord : nextList ){
	            	if( set.contains( nextWord ) && !nextWord.equals(end)){
	                    continue;
	                }
	                
	            	if( nextWord.equals(end) ){
	            		touchEnd = true;
	            	}
	            	
	                if( cur.next == null ){
	                	cur.next = new HashMap<>();
	                }
	                cur.next.put(nextWord, new LadderNode( nextWord ) );
	                q.offer( cur.next.get( nextWord) );
	            }
        	}
        	
        	if( touchEnd ){
        		break;
        	}
        }
        
        return root;
    }
    
    
    private List<String> expand(String cur, Set<String> dict ){
        List<String> expansion = new ArrayList<String>();
        
        for (int i = 0; i < cur.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != cur.charAt(i)) {
                    String expanded = replace( cur, i, ch);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }
       
        return expansion;
    }
    
    private class LadderNode{
        public String val;
        public HashMap<String, LadderNode> next;
        
        public LadderNode(String val){
            this.val = val;
            
        }
    }
    
    private void treeTrave(LadderNode root){
    	List<List<String>> result = new ArrayList<List<String>>();
    	
    	Queue<LadderNode> q = new LinkedList<LadderNode>();
    	q.offer( root );
    	
    	while( !q.isEmpty() ){
    		int size = q.size();
    		List<String> level = new ArrayList<String>();
    		for( int i = 0; i < size; i++ ){
    			LadderNode node = q.poll();
    			level.add( node.val );
    			if( node.next != null ){
	    			for(Map.Entry<String, LadderNode> entry : node.next.entrySet() ){
	    				q.offer( entry.getValue() );
	    			}
    			}
    		}
    		
    		result.add( level );
    	}
    	
    	for(List<String> level : result ){
    		for(int i = 0; i < level.size(); i++){
    			System.out.print( level.get(i) + " ");
    		}
    		System.out.println();
    	}
    	System.out.println("////////////////////////////////////");
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
        helper(dict, set1, set2, map, false);

        List<List<String>> res = new ArrayList<List<String>>();
        List<String> sol = new ArrayList<String>(Arrays.asList(start));

        // recursively build the final result
        generateList(start, end, map, sol, res);

        return res;
      }

      private boolean helper(Set<String> dict, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean BottomToTop) {
        if (set1.isEmpty()) {
          return false;
        }

        if (set1.size() > set2.size()) {
          return helper(dict, set2, set1, map, !BottomToTop);
        }

        // remove words on current both ends from the dict
        dict.removeAll(set1);
        dict.removeAll(set2);

        // as we only need the shortest paths
        // we use a boolean value help early termination
        boolean done = false;

        // set for the next level
        Set<String> set = new HashSet<String>();

        // for each string in end 1
        for (String str : set1) {
        	  List<String> nextWord = getNextWord(dict, str);

        	  for( String word : nextWord){

              // make sure we construct the tree in the correct direction
              String key = BottomToTop ? word : str;
              String val = BottomToTop ? str : word;

              List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();

              if (set2.contains(word)) {
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
        return done || helper(dict, set2, set, map, !BottomToTop);
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
