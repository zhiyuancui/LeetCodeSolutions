package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.SolveEquation;

public class SolveEquationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		SolveEquation s = new SolveEquation();
		s.solveEquation("x+5-3+x=6+x-2");
	}

}
