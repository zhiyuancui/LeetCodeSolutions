package solutions;

/**
 * 75 Sort Colors
 */
public class SortColor {
	public void sortColors2(int[] nums) {
        int second = nums.length -1, zero = 0;
        for( int i = 0; i <= second; i++ ) {
            while( nums[i] == 2  && i < second ) {
                swap( nums, i, second ) ;
                second--;
            }
            while( nums[i] == 0  && i > zero ) {
                swap( nums, i, zero );
                zero++;
            }
        }
    }
    
    private void swap( int[] nums, int i, int j ) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
