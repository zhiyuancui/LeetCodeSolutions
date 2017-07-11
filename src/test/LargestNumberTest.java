package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.LargestNumber;

public class LargestNumberTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		LargestNumber l = new LargestNumber();
		int[] nums = {3,30,34,5,9};
		l.largestNumber(nums);
	}

}
