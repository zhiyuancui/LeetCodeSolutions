package test;

import static org.junit.Assert.*;

import org.junit.Test;

import solutions.UglyNumber;

public class UglyNumberTest {

	@Test
	public void test() {
		UglyNumber u = new UglyNumber();
		u.nthSuperUglyNumber(12, new int[]{2,7,13,19});
	}

}
