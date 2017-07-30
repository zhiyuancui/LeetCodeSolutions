package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.CountDigitOne;

public class CountDigitOneTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		CountDigitOne c = new CountDigitOne();
		c.countDigitOne(123);
	}

}
