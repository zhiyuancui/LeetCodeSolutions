package solutions;

/**
 * Find Duplicate Number
 * @author Zhiyuan
 *
 */
public class FindDuplicate {
	public int findDuplicate(int[] nums) {
		if( nums == null || nums.length == 0 )
        {
            return 0;
        }
        
        int low = 0;
        int high = nums.length - 1;
        int mid = ( high + low ) / 2;
        
        while( high - low > 1){
            int count = 0;
            for(int i : nums)
            {
                if( i > mid && i <= high ){
                    count++;
                }
            }
            if( count > high - mid ){
                low = mid;
            }
            else{
                high = mid;
            }
            mid = ( high + low ) / 2;
        }
        
        return high;
    }
	
	public int findDuplicate2(int[] nums) {
		if( nums == null || nums.length <=1 )
        {
            return 0;
        }
        
        int slow = nums[0];
        int fast = nums[ nums[0] ];
        
        while( slow != fast ){
        	slow = nums[ slow ];
        	fast = nums[ nums[fast] ];
        }
        
        fast = 0;
        while( fast != slow ){
        	fast = nums[ fast ];
        	slow = nums[ slow ];
        }
        
        return slow;
    }
	
	public static void main(String[] args)
	{
		FindDuplicate f = new FindDuplicate();
		int[] nums = {1,2,2};
		f.findDuplicate(nums);
	}
}
