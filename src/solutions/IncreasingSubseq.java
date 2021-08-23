package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491 Increasing Subsequences
 */
public class IncreasingSubseq {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        List<Integer> solution = new ArrayList<>();

        backtrack(result, solution, nums, 0);

        return new ArrayList<>(result);
    }

    private void backtrack(Set<List<Integer>> result, List<Integer> solution, int[] nums, int start) {
        if(solution.size() > 1) {
            result.add(new ArrayList<>(solution));
        }

        for(int i = start; i < nums.length; i++) {
            if(solution.size() == 0 || solution.get(solution.size() - 1) <= nums[i]) {
                solution.add(nums[i]);
                backtrack(result, solution, nums, i + 1);
                solution.remove(solution.size() - 1);
            }
        }
    }
}
