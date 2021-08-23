package solutions;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 */
public class FindMinII {
    public int findMin2(int[] nums) {

        if( nums == null  || nums.length == 0 )
        {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        while( start < end )
        {
            int mid = start + ( end - start ) / 2;

            if( nums[ end ] > nums[ mid ] )
            {
                end = mid;
            }
            else if( nums[ end ] < nums[ mid ] )
            {
                start = mid + 1;
            }
            else
            {
                end--;
            }

        }

        return nums[start];
    }
}
