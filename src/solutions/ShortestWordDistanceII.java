package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 244 Shortest Word Distance II
 */
public class ShortestWordDistanceII {
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
}
