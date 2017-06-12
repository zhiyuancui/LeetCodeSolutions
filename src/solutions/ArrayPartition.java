package solutions;

import java.util.Arrays;

public class ArrayPartition {

	/**
	 * Array Partition I
	 * @param nums
	 * @return
	 */
	public int arrayPairSum(int[] nums) {
        if( nums == null || nums.length == 0 ) {
		return 0;
	}    

	if ( nums.length == 2 ){
		return Math.min( nums[0],nums[1] );
	}

	Arrays.sort( nums );

	int sum = 0;

	for(int i = nums.length -1; i >= 1; i-- ){
		int prev = i-1;
		sum += Math.min( nums[i],nums[prev]);
		i--;
	}
	return sum;
    }
}
