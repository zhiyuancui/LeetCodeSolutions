package solutions;

/**
 * 80 Remove Duplicates from Sorted Array II
 */
public class RemoveDuplicatesII {
    public int removeDuplicates2(int[] nums) {
        if( nums == null || nums.length <= 2 )
        {
            return nums.length;
        }

        int len = 2;
        int pos = 2;

        while( pos < nums.length )
        {
            if( nums[ len - 2] != nums[pos] )
            {
                nums[ len ] = nums[pos];
                len++;
            }
            pos++;
        }

        return len;
    }
}
