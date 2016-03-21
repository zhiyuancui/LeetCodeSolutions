package solutions;


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
	
	public static void main(String[] args)
	{
		FindDuplicate f = new FindDuplicate();
		int[] nums = {1,2,2};
		f.findDuplicate(nums);
	}
}
