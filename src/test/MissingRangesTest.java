package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.MissingRanges;

public class MissingRangesTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		MissingRanges m = new MissingRanges();
		m.findMissingRanges(new int[]{2147483647}, -2147483648, 2147483647);
	}

}
