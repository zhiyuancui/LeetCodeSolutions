package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.GenerateParenthesis;

public class GenerateParenthesisTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		GenerateParenthesis g = new GenerateParenthesis();
		g.generateParenthesis(3);
	}

}
