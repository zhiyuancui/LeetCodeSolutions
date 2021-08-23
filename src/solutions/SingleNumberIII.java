package solutions;

/**
 * 260 Single Number III
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if( nums == null || nums.length < 3 )
        {
            return nums;
        }

        int[] result = new int[2];

        int r = 0;
        for(int i : nums)
        {
            r ^= i;
        }

        int lowbit = r & -r;
        for( int n : nums)
        {
            if( ( n & lowbit) == 0 ){
                result[0] ^= n;
            }else{
                result[1] ^= n;
            }
        }

        return result;
    }
}
