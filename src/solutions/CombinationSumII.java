package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40 Combination Sum II
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates,
                                               int target) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (candidates.length < 1) {
            return results;
        }

        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        generate(results, path, candidates, 0, target);

        return results;
    }

    private void generate(List<List<Integer>> result, List<Integer> solution, int[] nums, int start, int target ){
        if( target == 0 ){
            result.add(new ArrayList<Integer>( solution ));
        }

        if( target < 0 ){
            return;
        }

        for(int i = start; i < nums.length; i++){
            if( i != start && nums[i] == nums[i-1] ){
                continue;
            }

            solution.add( nums[i] );
            generate(result, solution, nums, i+1, target - nums[i]);
            solution.remove( solution.size() - 1 );
        }
    }
}