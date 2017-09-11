package test;

import org.junit.Test;

import solutions.ReversePairs;

public class ReversePairsTest {

	@Test
	public void test() {
		ReversePairs r = new ReversePairs();
		int[] nums = {1,3,2,3,1};
		r.reversePairs(nums);
	}

}
