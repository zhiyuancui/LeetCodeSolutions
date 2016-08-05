package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.SimplifyPath;

public class SimplifyPathTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		SimplifyPath p = new SimplifyPath();
		p.simplifyPath("/");
	}

}
