package test;

import static org.junit.Assert.*;

import org.junit.Test;
import solutions.ComplexNumberMultiply;

public class ComplexNumberMultiplyTest {

	@Test
	public void test() {
		ComplexNumberMultiply c = new ComplexNumberMultiply();
		assertEquals( c.complexNumberMultiply("1+-1i", "1+-1i"), "0+-2i");
	}

}
