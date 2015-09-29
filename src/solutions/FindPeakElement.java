package solutions;

public class FindPeakElement {
	
	public int findPeakElement(int[] nums) {
	     
	     if( nums == null || nums.length < 1 )
	     {
	         return 0;
	     }   
	     
	     int peak = 0;
	     int prev = Integer.MIN_VALUE;
	     
	     for(int i = 0; i < nums.length; i++)
	     {
	         int left = i < nums.length-1 ? nums[i+1] : Integer.MIN_VALUE;
	         if( left < nums[i] )
	         {
	             if( prev < nums[i] )
	             {
	                 peak = i;
	             }
	         }
	         prev = nums[i];
	     }
	     
	     return peak;
	    }
}
