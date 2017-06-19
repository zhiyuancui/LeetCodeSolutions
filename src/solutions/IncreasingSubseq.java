package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubseq {
	public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res= new HashSet<List<Integer>>();
        List<Integer> holder = new ArrayList<Integer>();
        generate(res, holder, 0, nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>(res);
        return result;
    }
    
    private void generate(Set<List<Integer>> result, List<Integer> solution, int start, int[] nums){
        if( solution.size() > 1 ){
            result.add( new ArrayList( solution ) );
        }
        for (int i = start; i < nums.length; i++) {
            if(solution.size() == 0 || solution.get(solution.size() - 1) <= nums[i]) {
                solution.add(nums[i]);
                generate(result, solution, i + 1, nums);
                solution.remove(solution.size() - 1);
            }
        }
    }
}
