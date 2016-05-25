package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.CountPalindrome;

public class CountPalindromeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		CountPalindrome c = new CountPalindrome();
		assertEquals(c.longestPalindrome("aabbaa"),6);
	}

	@Test
	public void test2() {
		CountPalindrome c = new CountPalindrome();
		assertEquals(c.longestPalindrome("aa"),2);
	}
	
	@Test
	public void test3() {
		CountPalindrome c = new CountPalindrome();
		assertEquals(c.longestPalindrome("ab"),2);
	}
}
