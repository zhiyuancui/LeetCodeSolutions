package test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import solutions.DecodeWays;

public class DecodeWaysTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		DecodeWays d = new DecodeWays();
		d.numDecodings("012");
	}
	
	@Test
	public void testEmpty() {
		DecodeWays d = new DecodeWays();
		d.numDecodings("");
	}
	
	@Test
	public void test2() {
		DecodeWays d = new DecodeWays();
	}

}
