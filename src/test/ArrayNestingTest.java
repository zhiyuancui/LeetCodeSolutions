package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.ArrayNesting;

public class ArrayNestingTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ArrayNesting a = new ArrayNesting();
		int[] nums = {5,4,0,3,1,6,2};
		assertEquals(4,a.arrayNesting(nums));
	}

}
