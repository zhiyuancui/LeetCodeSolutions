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
   
   
   /**
    * Next Permutations
    * @param nums
    */
   public void nextPermutation(int[] nums) {
       
       if( nums == null || nums.length < 2 )
       {
           return;
       }
       
       
       //not increase order
       int pivotIndex = -1;
       int pivot = 0;
       for(int i = nums.length - 2; i >=0; i-- )
       {
           if( nums[ i + 1] > nums[i] )
           {
               pivotIndex = i;
               pivot = nums[i];
               break;
           }
       }
       if( pivotIndex != -1 ){
           //from right to left, the first number bigger than pivot
           int reverse = pivotIndex + 1;
           for(int i = nums.length - 1; i > pivotIndex; i--)
           {
               if( nums[i] > pivot )
               {
                   reverse = i;
                   break;
               }
           }
           nums[pivotIndex] = nums[reverse];
           nums[reverse] = pivot;
           
       }
       
       
       //reverse between them
       int start = pivotIndex + 1;
       int end = nums.length - 1;
       
       while( start < end )
       {
           int temp = nums[start];
           nums[start] = nums[end];
           nums[end] = temp;
           start++;
           end--;
       }
   }
   
   /**
    * Permutation Sequence
    * @param n
    * @param k
    * @return
    */
   public String getPermutation(int n, int k) {
       int pos = 0;
       List<Integer> numbers = new ArrayList<>();
       int[] factorial = new int[n+1];
       StringBuilder sb = new StringBuilder();
       
       // create an array of factorial lookup
       int sum = 1;
       factorial[0] = 1;
       for(int i=1; i<=n; i++){
           sum *= i;
           factorial[i] = sum;
       }
       // factorial[] = {1, 1, 2, 6, 24, ... n!}
       
       // create a list of numbers to get indices
       for(int i=1; i<=n; i++){
           numbers.add(i);
       }
       // numbers = {1, 2, 3, 4}
       
       k--;
       
       for(int i = 1; i <= n; i++){
           int index = k/factorial[n-i];
           sb.append(String.valueOf(numbers.get(index)));
           numbers.remove(index);
           k-=index*factorial[n-i];
       }
       
       return String.valueOf(sb);
   }
}
