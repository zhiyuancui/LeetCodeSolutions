package solutions;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	/**
	 * Generate Permutations
	 * @param num
	 * @return
	 */
	public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return rst; 
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(rst, list, num);
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
}
