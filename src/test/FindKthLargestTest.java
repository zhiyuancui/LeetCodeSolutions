package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import solutions.FindKthLargest;

public class FindKthLargestTest {

	@Test
	public void test() {
		FindKthLargest f = new FindKthLargest();
		int[] nums = {3,2,1,5,6,4};
		/*Random rand = new Random();
		for( int i = 0; i < nums.length; i++ ) {
			nums[i] = rand.nextInt(50);
		}*/
		System.out.println( f.findKthLargest2(nums, 2) );
	}

}
