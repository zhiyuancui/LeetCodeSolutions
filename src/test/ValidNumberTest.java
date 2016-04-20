package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.ValidNumber;

public class ValidNumberTest {

	ValidNumber v;
	@Before
	public void setUp() throws Exception {
		v = new ValidNumber();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		v.isNumber("1e-0");
	}

}
