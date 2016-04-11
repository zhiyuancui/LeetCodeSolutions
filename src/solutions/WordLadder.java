package solutions;

import java.util.ArrayList;
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
        List<String> path = new ArrayList<String>();
        
        dfs(root, ladders, path, endWord );
        
        return ladders;
    }
    
    private void dfs(LadderNode root, List<List<String>> ladders,List<String> path, String end )
    {
        if( root.next == null ){
            if( root.val.equals( end ) ){
                path.add( root.val );
                ladders.add(new ArrayList<String>( path ));
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
        set.add( start );
        
        LadderNode root = new LadderNode( start );
        q.offer( root );
         
        while( !q.isEmpty() ){
            LadderNode cur = q.poll();
            
            List<String> nextList = expand( cur.val, dict );
            for(String nextWord : nextList ){
            	if( set.contains( nextWord ) && !nextWord.equals(end)){
                    continue;
                }
                
                if( cur.next == null ){
                	cur.next = new HashMap<>();
                }
                cur.next.put(nextWord, new LadderNode( nextWord ) );
                q.offer( cur.next.get( nextWord) );
                set.add( nextWord );
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
    
    public static void main(String[] args){
    	WordLadder w = new WordLadder();
    	Set<String> wordList = new HashSet<String>();
    	wordList.add("hot");
    	wordList.add("dot");
    	wordList.add("dog");
    	wordList.add("lot");
    	wordList.add("log");
    	List<List<String>> result = w.findLadders("hit", "cog", wordList);
    	
    	for(List<String> path : result){
    		for(String s : path){
    			System.out.print(s + " ");
    		}
    		System.out.println();
    	}
    	
    }
}
