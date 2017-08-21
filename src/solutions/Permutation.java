package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

	/**
	 * Generate Permutations
	 * @param num
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst; 
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(rst, list, nums);
        return rst;
   }
   
   public void helper(List<List<Integer>> rst, ArrayList<Integer> list, int[] num){
       if(list.size() == num.length) {
           rst.add(new ArrayList<Integer>(list));
           return;
       }
       
       for(int i = 0; i<num.length; i++){
           if(list.contains(num[i])){
               continue;
           }
           list.add(num[i]);
           helper(rst, list, num);
           list.remove(list.size() - 1);
       }
       
   }
   
   /**
    * 
    * Permutation II
    */
   public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst; 
        }
        
        int[] used = new int[nums.length];
   
        Arrays.sort( nums );

        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(used, rst, list, nums);
        return rst;
   }
   
   public void helper(int[] used, List<List<Integer>> rst, ArrayList<Integer> list, int[] nums){
       if(list.size() == nums.length) {
           rst.add(new ArrayList<Integer>(list));
           return;
       }
       
       for(int i = 0; i<nums.length; i++){
           if(used[i] == 1 ||( i != 0 && nums[i-1] == nums[i] && used[i-1] == 0 )){
               continue;
           }
           list.add(nums[i]);
           used[i] = 1;
           helper(used,rst, list, nums);
           list.remove(list.size() - 1);
           used[i] = 0;
       }
       
   }
   
   
   
   
   
}
