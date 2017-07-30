package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.FindIntegers;

public class FindIntegersTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		FindIntegers f = new FindIntegers();
		f.findIntegers(5);
	}

}
