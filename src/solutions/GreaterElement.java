package solutions;

import java.util.Stack;

public class GreaterElement {

	
	/**
	 * Reference to: https://discuss.leetcode.com/topic/77881/typical-ways-to-solve-circular-array-problems-java-solution/2
	 * Next Greater Element II
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElements2(int[] nums) {
	        
	        int n = nums.length;
	        int[] result = new int[n];
	        
	        Stack<Integer> stack = new Stack<>();
	        for(int i = n-1; i >= 0; i--){
	            stack.push(i);
	        }
	        
	        for(int i = n - 1; i >= 0; i--){
	            result[i] = -1;
	            while( !stack.isEmpty() && nums[ stack.peek()] <= nums[i] ){
	                stack.pop();
	            }
	            
	            if( !stack.isEmpty() ){
	                result[i] = nums[ stack.peek() ];
	            }
	            stack.add(i);
	        }
	        
	        return result;
	}
}
