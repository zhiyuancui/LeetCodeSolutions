package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 * For example,
 * Given the following words in dictionary,
 * [
 * "wrt",
 * "wrf",
 * "er",
 * "ett",
 * "rftt"
 * ]
 * The correct order is: "wertf".
 * 
 * Reference to https://leetcode.com/discuss/66716/java-ac-solution-using-bfs
 * @author Zhiyuan
 *
 */

public class AlienDict {
	public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree = new HashMap<Character, Integer>();
        
        String result = "";
        
        if( words == null || words.length == 0 ){
        	return result;
        }
        
        for(String s : words ){
        	for( char c : s.toCharArray() ){
        		degree.put(c,0);
        	}
        }
        
        for(int i = 0; i < words.length - 1; i++){
        	String cur = words[i];
        	String next = words[i+1];
        	
        	int length = Math.min(cur.length(), next.length());
        	
        	for(int j = 0; j < length; j++){
        		char c1 = cur.charAt(j);
        		char c2 = next.charAt(j);
        		if( c1 != c2 ){
        			Set<Character> set = new HashSet<Character>();
        			if( map.containsKey(c1) ){
        				set = map.get(c1);
        			}
        			if( !set.contains(c2) ){
        				set.add(c2);
        				map.put(c1,set);
        				degree.put( c2, degree.get(c2) + 1);
        			}
        			break;
        		}
        	}
        }
        
        Queue<Character> q = new LinkedList<Character>();
        
        for( char c: degree.keySet() ){
        	if( degree.get(c) == 0 ){
        		q.offer(c);
        	}
        }
        
        while( !q.isEmpty() ){
        	char cur = q.poll();
        	
        	result += cur;
        	if( map.containsKey(cur) ){
        		for( char c2 : map.get( cur ) ){
        			degree.put(c2, degree.get(c2) - 1);
        			if( degree.get(c2) == 0 ){
        				q.offer( c2 );
        			}
        		}
        	}
        }
        
        if( result.length() != degree.size() ){
        	return "";
        }
        
        return result;
    }
}
