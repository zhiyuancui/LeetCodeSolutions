package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 77 Combinations
 */
public class Combine {

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
