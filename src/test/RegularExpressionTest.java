package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import solutions.RegularExpression;


public class RegularExpressionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		RegularExpression r = new RegularExpression();
		r.isMatch2("aab", "c*a*b");
	}
	
	@Test
	public void test2() {
		RegularExpression r = new RegularExpression();
		assertEquals(r.isMatch2("bbba", "bbbc*a"),true);
	}

	@Test
	public void test3() {
		RegularExpression r = new RegularExpression();
		assertEquals(r.isMatch2("bbba", "b*a"),true);
	}
	
	@Test
	public void test4() {
		RegularExpression r = new RegularExpression();
		assertEquals(r.isMatch2("ba", "b*a"),true);
	}
	
}
