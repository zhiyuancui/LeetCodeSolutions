package solutions;

/**
 * 45 Jump Game II
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int step = 0;

        if( nums == null || nums.length == 0 )
        {
            return 0;
        }

        int available = nums[0];
        int last = 0;

        for(int i = 1; i < nums.length; i++ )
        {

            if( last < i )
            {
                step++;
                last = available;
            }

            available = Math.max( available, i + nums[i]);
        }

        return step;
    }
}
