package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import solutions.CountBits;

public class CountBitsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		CountBits c = new CountBits();
		c.countBits2(5);
	}

}
