package test;

import org.junit.Test;

import solutions.LengthOfLIS;

public class LengthOfLISTest {

	@Test
	public void test() {
		LengthOfLIS l = new LengthOfLIS();
		int[] nums = {10,9,2,5,3,7,101,18};
		l.lengthOfLIS(nums);
	}

}
