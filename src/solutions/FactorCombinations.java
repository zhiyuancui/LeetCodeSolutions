package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as product of its factors. For example,
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * 
 * Note: 
 * 
 * Each combination's factors must be sorted ascending, 
 * for example: The factors of 2 and 6 is [2, 6], not [6, 2]
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * 
 * 
 * Reference to: https://leetcode.com/discuss/51250/my-recursive-dfs-java-solution
 * 
 * @author Zhiyuan
 *
 */

public class FactorCombinations {

	public List<List<Integer>> getFactors(int n) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    helper(result, new ArrayList<Integer>(), n, 2);
	    return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
	    if (n <= 1) {
	        if (item.size() > 1) {
	            result.add(new ArrayList<Integer>(item));
	        }
	        return;
	    }

	    for (int i = start; i <= n; ++i) {
	        if (n % i == 0) {
	            item.add(i);
	            helper(result, item, n/i, i);
	            item.remove(item.size()-1);
	        }
	    }
	}
}
