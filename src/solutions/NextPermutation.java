package solutions;

public class NextPermutation {
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
}
