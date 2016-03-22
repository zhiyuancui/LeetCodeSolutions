package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( nums == null || nums.length == 0 ){
            return result;
        }
        
        List<Integer> solution = new ArrayList<Integer>();
        Arrays.sort( nums );
        generate(result, solution, 0, nums);
        return result;
    }
    
    private void generate(List<List<Integer>> result, List<Integer> solution, int start, int[] nums ){
        result.add( new ArrayList( solution ) );
        
        for(int i = start; i < nums.length; i++ ){
            solution.add(nums[i]);
            generate(result, solution, i + 1, nums);
            solution.remove( solution.size() - 1);
        }
    }
    
    
    /**
     * With duplicates
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if( nums == null || nums.length == 0 ){
            return result;
        }
        
        Arrays.sort( nums );
        List<Integer> solution = new ArrayList<Integer>();
        generate2(result, solution, nums,0);
        return result;
    }
    
    private void generate2(List<List<Integer>> result, List<Integer> solution, int[] nums, int start){
        result.add( new ArrayList<Integer>( solution ) );
        
        for(int i = start;i< nums.length; i++){
            if( i != start && nums[ i - 1] == nums[i] ){
                continue;
            }
            solution.add(nums[i]);
            generate2(result, solution, nums,i+1);
            solution.remove( solution.size() - 1);
            
        }
    }
}
