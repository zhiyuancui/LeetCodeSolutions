package solutions;

/**
 * 162 Find Peak Element
 */
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
	         int right = i < nums.length-1 ? nums[i+1] : Integer.MIN_VALUE;
	         if( right < nums[i] )
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

	public int findPeakElement2(int[] nums) {
		if(nums == null || nums.length == 0) {
			return -1;
		}

		int start = 0;
		int end = nums.length - 1;

		while(start < end) {
			int mid = start + (end - start) / 2;
			int left = mid - 1 >= 0 ? nums[mid-1] : Integer.MIN_VALUE;
			int right = mid + 1 < nums.length ? nums[mid+1] : Integer.MIN_VALUE;

			System.out.println(left + " " + nums[mid] + " " + right);

			if(nums[mid] > left && nums[mid] > right) {
				return mid;
			} else if(nums[mid] < left){
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}
}
