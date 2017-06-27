package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.ContainsDuplicate;

public class ContainsDuplicateTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ContainsDuplicate c = new ContainsDuplicate();
		int[] nums = new int[2];
		c.containsNearbyDuplicate(nums, 3);
	}

}
