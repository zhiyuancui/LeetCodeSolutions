package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {

	
	
	
	/**
	 * 
	 * Shortest Word Distance II
	 * 
	 * This is a follow up of Shortest Word Distance. 
	 * The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. 
	 * How would you optimize it?
	 * 
	 * Design a class which receives a list of words in the constructor,
	 * and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
	 * For example,
	 * 
	 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
	 * 
	 * Given word1 = ¡°coding¡±, word2 = ¡°practice¡±, return 3.
	 * 
	 * Given word1 = "makes", word2 = "coding", return 1.
	 * 
	 * Note:
	 * 
	 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
	 * 
	 * Reference to : https://leetcode.com/discuss/50190/java-solution-using-hashmap
	 * 
	 * @param words
	 */
	
	private Map<String, List<Integer>> map;
	
	public void WordDistance(String[] words) {
		map = new HashMap<String, List<Integer>>();
	    for(int i = 0; i < words.length; i++) {
	        String w = words[i];
	        if(map.containsKey(w)) {
	            map.get(w).add(i);
	        } else {
	            List<Integer> list = new ArrayList<Integer>();
	            list.add(i);
	            map.put(w, list);
	        }
	    }
    }

    public int shortest(String word1, String word2) {
    	List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ret = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            int index1 = list1.get(i), index2 = list2.get(j);
            if(index1 < index2) {
                ret = Math.min(ret, index2 - index1);
                i++;
            } else {
                ret = Math.min(ret, index1 - index2);
                j++;
            }
        }
        return ret;
    }
    
    /**
     * 
     * Shortest Word Distance III
     * 
     * This is a follow up of Shortest Word Distance. 
     * The only difference is now word1 could be the same as word2.
     * 
     * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
     * 
     * word1 and word2 may be the same and they represent two individual words in the list.
     * 
     * For example,
     * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
     * 
     * Given word1 = ¡°makes¡±, word2 = ¡°coding¡±, return 1.
     * Given word1 = "makes", word2 = "makes", return 3.
     * 
     * Reference to : https://leetcode.com/discuss/50715/12-16-lines-java-c
     * 
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestWordDistance3(String[] words, String word1, String word2) {
    	long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
        boolean same = word1.equals(word2);
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                if (same) {
                    i1 = i2;
                    i2 = i;
                } else {
                    i1 = i;
                }
            } else if (words[i].equals(word2)) {
                i2 = i;
            }
            dist = Math.min(dist, Math.abs(i1 - i2));
        }
        return (int) dist;
    }
	
}
