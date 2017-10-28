package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.MaximumSwap;

public class MaximumSwapTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		MaximumSwap m = new MaximumSwap();
		m.maximumSwap(2736);
	}

}
