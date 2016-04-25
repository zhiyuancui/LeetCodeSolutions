package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.RegularExpression;


public class RegularExpressionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		RegularExpression r = new RegularExpression();
		r.isMatch2("aab", "c*a*b");
	}

}
