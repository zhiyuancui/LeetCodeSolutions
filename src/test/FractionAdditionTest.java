package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import solutions.FractionAddition;

public class FractionAdditionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void test() {
		FractionAddition f = new FractionAddition();
		assertEquals( "1/3", f.fractionAddition("-1/2+1/2+1/3") );
	}

}
