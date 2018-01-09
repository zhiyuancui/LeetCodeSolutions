package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutoCompleteSystem {
	class TrieNode {
        Map<Character, TrieNode> next;
        Map<String,Integer> count;
        public TrieNode() {
            next = new HashMap<>();
            count = new HashMap<>();
        }
    }
    
    class Pair{
        int count;
        String s;
        public Pair( String s, int c ) {
            count = c;
            this.s = s;
        }
    }
    
    TrieNode root = new TrieNode();
    String prefix = "";
    public AutoCompleteSystem(String[] sentences, int[] times) {
        for( int i = 0; i < sentences.length; i++ ) {
            addWord(  sentences[i], times[i]);
        }
    }
    
    private void addWord( String s, int time ) {
        TrieNode cur = root;
        for( char c : s.toCharArray() ) {
            if( !cur.next.containsKey(c) ) {
                cur.next.put(c , new TrieNode() );                              
            }
            cur = cur.next.get(c);
            cur.count.put( s, cur.count.getOrDefault(s,0) + time );
        }
    }
   
    
    public List<String> input(char c) {
        if( c == '#' ) {
            addWord(prefix, 1 );
            prefix = "";
            return new ArrayList<>();
        }
        prefix = prefix + c;
        TrieNode cur = root;
        for( char cc : prefix.toCharArray() ) {
            if( !cur.next.containsKey(cc) ) {
                return new ArrayList<>();
            }
            cur = cur.next.get(cc);
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>( (a,b) -> {
            if( a.count != b.count ) {
                return b.count - a.count;
            } else {
                return a.s.compareTo(b.s);
            }
        });
        
        for( String key : cur.count.keySet() ) {
            q.add( new Pair(key, cur.count.get(key) ) );
        }
        
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 3 && !q.isEmpty(); i++ ){
            result.add( q.poll().s );
        }
        return result;
    }
}
