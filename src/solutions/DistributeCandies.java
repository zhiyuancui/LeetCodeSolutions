package solutions;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

	/**
	 * Reference to https://discuss.leetcode.com/topic/88507/java-solution-3-lines-hashset
	 * @param candies
	 * @return
	 */
	public int distributeCandies(int[] candies) {
        
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) kinds.add(candy);
        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
        
    }
	
}
