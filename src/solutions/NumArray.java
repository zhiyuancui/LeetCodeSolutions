package solutions;
/**
 * Range Sum Query - Immutable
 * @author zhiyuan.cui
 *
 */
public class NumArray {

	int[] sums;
    public NumArray(int[] nums) {
        if( nums == null || nums.length == 0 ) {
            return;
        }
        
        sums = new int[ nums.length + 1 ];
        for( int i = 0; i < nums.length; i++ ) {
            sums[i+1] = sums[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
}
