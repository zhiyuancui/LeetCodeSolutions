package test;

import static org.junit.Assert.*;

import org.junit.Test;

import solutions.RemoveKDigits;

public class RemoveKDigitsTest {

	@Test
	public void test() {
		RemoveKDigits r = new RemoveKDigits();
		r.removeKdigits("100", 1);
	}

}
