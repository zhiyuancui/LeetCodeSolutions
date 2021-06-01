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
		if(words == null || words.length == 0) {
			return "";
		}

		Map<Character, Set<Character>> graph = new HashMap<>();
		Map<Character, Integer> indegree = new HashMap<>();

		for(String s : words ){
			for( char c : s.toCharArray() ){
				indegree.put(c,0);
			}
		}

		for(int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i+1];

			if (word1.length() > word2.length() && word1.startsWith(word2)) {
				return "";
			}

			int len = Math.min(word1.length(), word2.length());
			for(int j = 0; j <len; j++) {
				char c1 = word1.charAt(j);
				char c2 = word2.charAt(j);

				if(c1 != c2) {
					Set<Character> next = graph.getOrDefault(c1, new HashSet<>());
					graph.put(c1, next);
					if(!next.contains(c2)) {
						next.add(c2);
						indegree.put(c2, indegree.get(c2)+1);
					}
					break;
				}
			}
		}


		Queue<Character> queue = new LinkedList<>();
		for(char key : indegree.keySet()) {
			if(indegree.get(key) == 0) {
				queue.add(key);
			}
		}

		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			char cur = queue.poll();
			sb.append(cur);
			if(graph.containsKey(cur)) {
				for(char next : graph.get(cur)) {
					indegree.put(next, indegree.get(next)-1);
					if(indegree.get(next) == 0) {
						queue.add(next);
					}
				}
			}
		}

		if(sb.length() != indegree.size()) {
			return "";
		}

		return sb.toString();
	}
}
