package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.RussianDollEnvelopes;

public class RussianDollEnvelopesTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		RussianDollEnvelopes r = new RussianDollEnvelopes();
		int[][] envelopes = {{5,3},{5,4}};
		r.maxEnvelopes(envelopes);
	}

}
