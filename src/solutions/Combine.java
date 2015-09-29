package solutions;

import java.util.ArrayList;
import java.util.List;

public class Combine {

	/**
	 * Given two integers n and k, 
	 * return all possible combinations of k numbers out of 1 ... n.
	 * For example,
	 * If n = 4 and k = 2, a solution is:
	 * [2,4],
	 * [3,4],
	 * [2,3],
	 * [1,2],
	 * [1,3],
	 * [1,4]
	 * @param n
	 * @param k
	 * @return
	 */
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( k <= 0 )
        {
            return result;
        }
        List<Integer> solution = new ArrayList<Integer>();
        
        builder(result, solution, n, k, 1);
        return result;
    }
    
    private void builder(List<List<Integer>> rst, List<Integer> solution, int n, int k, int start) {

        if (solution.size() == k){
            rst.add(new ArrayList(solution));
            return;
        }
        
        for(int i = start; i<= n; i++){
            solution.add(i);
            builder(rst, solution, n, k, i+1); 
            solution.remove(solution.size() - 1);
        }
    }
}
